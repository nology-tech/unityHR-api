package com.example.unityHR.Services;

import com.example.unityHR.DTO.TicketDTO;
import com.example.unityHR.Exceptions.ResourceNotFoundException;
import com.example.unityHR.Models.Ticket;
import com.example.unityHR.Models.TicketsAssignees;
import com.example.unityHR.Models.TicketsResponses;
import com.example.unityHR.Repositories.TicketAssigneesRepository;
import com.example.unityHR.Repositories.TicketRepository;
import com.example.unityHR.Repositories.TicketResponsesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketAssigneesRepository ticketAssigneesRepository;
    @Autowired
    TicketResponsesRepository ticketResponsesRepository;

    public TicketDTO getTicketById(int id) throws Exception{

        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        List<TicketsAssignees> ticketsAssigneesList = ticketAssigneesRepository.findAllByticketid(id);
        List<TicketsResponses> ticketsResponsesList = ticketResponsesRepository.findAllByticketid(id);
        Ticket ticket;

        if(!optionalTicket.isPresent()){
            throw new ResourceNotFoundException();
        }
        ticket=optionalTicket.get();
        TicketDTO ticketDTO=new TicketDTO();
        BeanUtils.copyProperties(ticket,ticketDTO);

        ticketDTO.setAssignees(ticketsAssigneesList.stream().map(assignee -> assignee.getEmailVerified()).collect(Collectors.toList()));
        ticketDTO.setResponses(ticketsResponsesList.stream().map(response -> {
            TicketDTO.TicketResponseDTO ticketResponseDTO=new TicketDTO.TicketResponseDTO();
            BeanUtils.copyProperties(response,ticketResponseDTO);
            return ticketResponseDTO;
        }).collect(Collectors.toList()));
        return ticketDTO;
    }
}

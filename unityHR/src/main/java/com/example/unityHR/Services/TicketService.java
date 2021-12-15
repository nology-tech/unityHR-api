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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Service
@Transactional
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketAssigneesRepository ticketAssigneesRepository;
    @Autowired
    TicketResponsesRepository ticketResponsesRepository;

    public TicketDTO getTicketById(int id) throws ResourceNotFoundException{

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

    //To delete ticket from entity ticket, assignees and responses
    public ResponseEntity<String> deleteTicketFromAllEntities(@PathVariable String id){
        ticketRepository.deleteById(parseInt(id));
        if (ticketAssigneesRepository.existsById(parseInt(id))) {
            ticketAssigneesRepository.deleteById(parseInt(id));
        }
        if (ticketResponsesRepository.existsById(parseInt(id))) {
            ticketResponsesRepository.deleteById(parseInt(id));
        }
        return ResponseEntity.status(HttpStatus.GONE).body("Deleted ticket : " + id);
    }

}

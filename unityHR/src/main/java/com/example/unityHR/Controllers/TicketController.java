package com.example.unityHR.Controllers;

//import com.example.unityHR.Models.*;
import com.example.unityHR.DTO.TicketDTO;
import com.example.unityHR.Exceptions.ResourceNotFoundException;
import com.example.unityHR.Models.JobTitles;
import com.example.unityHR.Models.Ticket;
import com.example.unityHR.Repositories.TicketRepository;
import com.example.unityHR.Services.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@RestController
@CrossOrigin(origins = "https://unityhr-d3bf1.web.app")
public class TicketController {
        @Autowired
        TicketRepository ticketRepository;
//        @Autowired
//        TicketAssigneesRepository ticketAssigneesRepository;
//        @Autowired
//        TicketResponsesRepository ticketResponsesRepository;
        @Autowired
        TicketService ticketService;

        //GET all tickets
        @GetMapping("/tickets")
        public ResponseEntity<List<TicketDTO>> getTickets(){
//            return ResponseEntity.status(HttpStatus.OK).body(ticketRepository.findAll());
                //get list of all tkts from tkt repo
                //for each tickt, make titcket DTO and send list of tkt DTO
                List<Ticket> ticketList = ticketRepository.findAll();
                List <TicketDTO> ticketDTOList = ticketList.stream().map((ticket) -> {
//                        System.out.println(ticket.getId());
//                        System.out.println(ticketService.getTicketById(ticket.getId()));
                        return ticketService.getTicketById(ticket.getId());
                }).collect(Collectors.toList());
                return ResponseEntity.status(HttpStatus.OK).body(ticketDTOList);
        }

        //GET a ticket by ID quote
        @GetMapping("/ticket/{id}")
        public ResponseEntity<TicketDTO> getTicket(@PathVariable String id) {
//            return ResponseEntity.status(HttpStatus.OK).body(ticketRepository.findById(parseInt(id)));
                try{
                        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicketById(parseInt(id)));

                }catch (ResourceNotFoundException e){
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
        }

        //POST a new ticket
        @PostMapping("/ticket")
        public ResponseEntity<String> addTicket(@RequestBody Ticket ticket){
                // Mandatory field validations need to be discussed once
                System.out.println("Received ticket:"+ticket);
                ticketRepository.save(ticket);
                return ResponseEntity.status(HttpStatus.CREATED).body("Ticket has been added");
        }

//        //PATCH a ticket
//        @PatchMapping(path="/ticket/{id}", consumes = "application/json-patch+json")
//        public ResponseEntity<Ticket> patchTicket(@PathVariable String id,@RequestBody JsonPatch patch){
//                try {
//                        Ticket ticket = ticketRepository.findById(parseInt(id));
//                        Ticket ticketPatched = applyPatchToTicket(patch, ticket);
//                        ticketRepository.updateTicket(ticketPatched);
//                        return ResponseEntity.status(HttpStatus.OK).body(ticketPatched);
//                } catch ( JsonProcessingException e) {
//                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//                } catch (Exception e) {
//                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//                }
//        }

        @PatchMapping("/ticket/{id}")
        public ResponseEntity<Ticket> updateTicket(@PathVariable String id, @RequestBody Ticket ticket) {


                if(ticketRepository.findById(parseInt(id)) !=null){
//                        //Ticket ticket = ticketRepository
//                                .findById(parseInt(id)).orElseThrow();
                        Ticket originalTicket = ticketRepository.findById(parseInt(id)).orElseThrow();
                        Ticket updatedTicket = ticketRepository.findById(parseInt(id)).orElseThrow();

                        if(ticket.getDescription() != null)
                        {updatedTicket.setDescription(ticket.getDescription());
                        }else{
                             originalTicket.setDescription(originalTicket.getDescription());
                        }
                        if(ticket.getRequestType() != null)
                        {updatedTicket.setRequestType(ticket.getRequestType());
                        } else {
                                originalTicket.setRequestType(originalTicket.getRequestType());
                        }
                        if(ticket.getTitle() != null)
                        {updatedTicket.setTitle(ticket.getTitle());
                        } else {
                                originalTicket.setTitle(originalTicket.getTitle());
                        }
                        if(ticket.getStatus() != null)
                        {updatedTicket.setStatus(ticket.getStatus());} else {
                                originalTicket.setStatus(originalTicket.getStatus());
                        }

                        ;
                        ticketRepository.save(updatedTicket);



                        return ResponseEntity
                                .status(HttpStatus.OK)
                                .header("ticket updated", "id: " + id)
                                .body(updatedTicket);

                } else {
                        throw new ResourceNotFoundException();
                }
        }


        //Delete a ticket
        @DeleteMapping("/ticket/{id}")
        @Transactional
        public ResponseEntity<String> deleteTicket(@PathVariable String id){
            // Valid 'id' check has to be added
                   ticketService.deleteTicketFromAllEntities(id);
            return ResponseEntity.status(HttpStatus.GONE).body("Deleted ticket : " + id);
        }

}

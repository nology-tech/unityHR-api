package com.example.unityHR.Controllers;

//import com.example.unityHR.Models.*;
import com.example.unityHR.DTO.TicketDTO;
import com.example.unityHR.Exceptions.ResourceNotFoundException;
import com.example.unityHR.Models.Ticket;
import com.example.unityHR.Repositories.TicketAssigneesRepository;
import com.example.unityHR.Repositories.TicketRepository;
import com.example.unityHR.Repositories.TicketResponsesRepository;
import com.example.unityHR.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
        public ResponseEntity<List<Ticket>> getTickets(){
//            return ResponseEntity.status(HttpStatus.OK).body(ticketRepository.findAll());
                //get list of all tkts from tkt repo
                //for each tickt, make titcket DTO and send list of tkt DTO

                return null;
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

        //Delete a ticket
        @DeleteMapping("/ticket/{id}")
        @Transactional
        public ResponseEntity<String> deleteTicket(@PathVariable String id){
            // Valid 'id' check has to be added
            ticketRepository.deleteById(parseInt(id));
            return ResponseEntity.status(HttpStatus.GONE).body("Deleted ticket : " + id);
        }


}

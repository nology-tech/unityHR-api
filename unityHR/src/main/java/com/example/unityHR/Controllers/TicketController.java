package com.example.unityHR.Controllers;

//import com.example.unityHR.Models.*;
import com.example.unityHR.Models.Ticket;
import com.example.unityHR.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
public class TicketController {
        @Autowired
        TicketRepository ticketRepository;

        //GET all tickets
        @GetMapping("/tickets")
        public ResponseEntity<List<Ticket>> getTickets(){
            return ResponseEntity.status(HttpStatus.OK).body(ticketRepository.findAll());
        }

        //GET a ticket by ID quote
        @GetMapping("/ticket/{id}")
        public ResponseEntity<Optional<Ticket>> getTicket(@PathVariable String id){
            return ResponseEntity.status(HttpStatus.OK).body(ticketRepository.findById(parseInt(id)));
        }

        //POST a new ticket
        @PostMapping("/ticket")
        public ResponseEntity<String> addTicket(@RequestBody Ticket ticket){
                // Mandatory field validations need to be discussed once
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

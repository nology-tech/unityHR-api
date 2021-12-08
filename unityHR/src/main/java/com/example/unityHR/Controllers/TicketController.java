package com.example.unityHR.Controllers;

//import com.example.unityHR.Models.*;
import com.example.unityHR.Models.Ticket;
import com.example.unityHR.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketController {
        private ArrayList<Ticket> tickets = new ArrayList<>();

        @Autowired
        TicketRepository repository;

        //GET all tickets
        @GetMapping("/tickets")
        public ResponseEntity<List<Ticket>> getTickets(){
                //  return ResponseEntity.status(HttpStatus.OK).body(tickets);
            return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());

        }

        //GET a ticket by ID quote
        @GetMapping("/ticket/{id}")
        public ResponseEntity<Ticket> getTicket(@PathVariable String id){
                // This has to be changed to get by Id ...Currently, it access the id by using position
                // Also, the validation check whether the id is valid or not to be added
                // Currently, the Path variable 'id' is taken as an int, but the actual 'id' in ticket is 'String'
                // return ResponseEntity.status(HttpStatus.OK).body(tickets.get(id));
            return ResponseEntity.status(HttpStatus.OK).body(repository.getById(id));

        }

        //POST a new ticket
        @PostMapping("/ticket")
        public ResponseEntity<String> addTicket(@RequestBody Ticket ticket){
                // Mandatory field validations need to be discussed once
                //  tickets.add(ticket);
                // ticket id can be shown in the response body - future
                repository.save(ticket);
                return ResponseEntity.status(HttpStatus.CREATED).body("Ticket has been added");
        }

        //Delete a ticket
        @DeleteMapping("/ticket/{id}")
        public ResponseEntity<String> deleteTicket(@PathVariable String id){
                // Valid 'id' check has to be added
                //  tickets.remove(index);
                // tickets.removeIf(ticket -> ticket.getId() == id);
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.GONE).body("Deleted ticket : " + id);
        }

}

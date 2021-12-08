package com.example.unityHR.Controllers;

//import com.example.unityHR.Models.*;
import com.example.unityHR.Models.Ticket;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@RestController
public class TicketController {
        private ArrayList<Ticket> tickets = new ArrayList<>();

        //GET all tickets
        @GetMapping("/tickets")
        public ResponseEntity<ArrayList<Ticket>> getTickets(){
            return ResponseEntity.status(HttpStatus.OK).body(tickets);
        }

        //GET a ticket by ID quote
        @GetMapping("/ticket")
        public ResponseEntity<Ticket> getTicket(@PathVariable int index){
            return ResponseEntity.status(HttpStatus.OK).body(tickets.get(index));
        }

        //POST a new ticket
        @PostMapping("/ticket")
        public ResponseEntity<String> addTicket(@RequestBody Ticket ticket){
                tickets.add(ticket);
                return ResponseEntity.status(HttpStatus.CREATED).body("Added new ticket");
        }

        //Delete a quote
        @DeleteMapping("/quote")
        public ResponseEntity<String> deleteQuote(@RequestBody String ticketID){
            tickets.removeIf(ticket -> ticket.getId() == ticketID);
//          tickets.remove(index);
            return ResponseEntity.status(HttpStatus.GONE).body("Deleted ticket" + ticketID);
        }

}

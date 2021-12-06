package com.example.unityHR.Controllers;

import com.example.unityHR.Models.Ticket;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TicketController {
        private ArrayList<Ticket> tickets = new ArrayList<>();

        //GET all tickets
        @GetMapping("/tickets")
        public ArrayList<Ticket> getTickets(){
            return tickets;
        }

        //GET a ticket by ID quote
        @GetMapping("/ticket")
        public Ticket getTicket(@PathVariable int index){
            return tickets.get(index);
        }

        //POST a new ticket
        @PostMapping("/ticket")
        public void addTicket(@RequestBody Ticket ticket){
            tickets.add(ticket);
        }

        //Delete a quote
        @DeleteMapping("/quote")
        public void deleteQuote(@RequestBody String ticketID){
            tickets.removeIf(ticket -> ticket.getId() == ticketID);
//            tickets.remove(index);
        }

}

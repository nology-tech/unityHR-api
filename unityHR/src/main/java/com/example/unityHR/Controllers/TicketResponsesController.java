package com.example.unityHR.Controllers;

//import com.example.unityHR.Models.*;

import com.example.unityHR.Models.TicketsResponses;
import com.example.unityHR.Repositories.TicketResponsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@CrossOrigin
public class TicketResponsesController {

        @Autowired
        TicketResponsesRepository ticketResponsesRepository;

        //GET all responses for a ticket id
        @GetMapping("/ticket/{ticketId}/responses")
        public ResponseEntity<List<TicketsResponses>> getTicketResponses(@PathVariable String ticketId){
                List<TicketsResponses> ticketsResponsesList = (List<TicketsResponses>) ticketResponsesRepository.findAllByticketid(parseInt(ticketId));
            return ResponseEntity.status(HttpStatus.OK).body(ticketsResponsesList);
        }

        //POST a new response to existing ticket
        @PostMapping("/ticket/response")
        public ResponseEntity<String> addTicketResponses(@RequestBody TicketsResponses ticketsResponses){
                ticketResponsesRepository.save(ticketsResponses);
                return ResponseEntity.status(HttpStatus.CREATED).body("Response added to ticket: "+ticketsResponses.getTicketid());
        }
}

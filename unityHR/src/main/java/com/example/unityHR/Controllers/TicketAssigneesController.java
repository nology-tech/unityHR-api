package com.example.unityHR.Controllers;

//import com.example.unityHR.Models.*;

import com.example.unityHR.Models.TicketsAssignees;
import com.example.unityHR.Repositories.TicketAssigneesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
//@CrossOrigin(origins = "https://unityhr-d3bf1.web.app")
@CrossOrigin
public class TicketAssigneesController {

        @Autowired
        TicketAssigneesRepository ticketAssigneesRepository;

        //GET all assignees for a ticket id
        @GetMapping("/ticket/{ticketId}/assignees")
        public ResponseEntity<List<TicketsAssignees>> getTicketAssignees(@PathVariable String ticketId){
                List<TicketsAssignees> ticketsAssigneesList = (List<TicketsAssignees>) ticketAssigneesRepository.findAllByticketid(parseInt(ticketId));
                System.out.println(ticketsAssigneesList);
                return ResponseEntity.status(HttpStatus.OK).body(ticketsAssigneesList);
        }

        //POST a new assignee to existing ticket
        @PostMapping("/ticket/assignee")
        public ResponseEntity<String> addTicketAssignees(@RequestBody TicketsAssignees ticketsAssignees){
                System.out.println(ticketsAssignees);
                ticketAssigneesRepository.save(ticketsAssignees);
                return ResponseEntity.status(HttpStatus.CREATED).body("Assignee added for ticket: "+ticketsAssignees.getTicketid());
        }

        //DELETE an assignee from  existing ticket
        @DeleteMapping("/ticket/{ticketId}/assignee/{emailVerified}")
        @Transactional
        public ResponseEntity<String> deleteTicketAssignees(@PathVariable int ticketId,@PathVariable String emailVerified){
                long rowsDeleted=ticketAssigneesRepository.deleteByTicketidAndEmailVerified(ticketId,emailVerified);
                return ResponseEntity.status(HttpStatus.OK).body(rowsDeleted+" assignee(s) deleted for ticket: "+ticketId);
        }
}

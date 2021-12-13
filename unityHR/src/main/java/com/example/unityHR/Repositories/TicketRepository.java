package com.example.unityHR.Repositories;

import com.example.unityHR.Models.Ticket;
import com.example.unityHR.Models.TicketsAssignees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
//    List<TicketsAssignees> findAllByticketid(int ticketid);
}

package com.example.unityHR.Repositories;

import com.example.unityHR.Models.TicketsAssignees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketAssigneesRepository extends JpaRepository<TicketsAssignees, Integer> {
    List<TicketsAssignees> findAllByticketid(int ticketid);
    boolean existsAllByticketid(int ticketid);
    void deleteAllByticketid(int ticketid);
    long deleteByTicketidAndEmailVerified(int ticketid, String emailVerified);

//    void deleteAllById(int parseInt);
}

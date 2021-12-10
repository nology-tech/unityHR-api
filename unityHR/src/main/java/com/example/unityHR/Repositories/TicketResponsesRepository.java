package com.example.unityHR.Repositories;

import com.example.unityHR.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketAssigneesRepository extends JpaRepository<Ticket, Integer> {

}

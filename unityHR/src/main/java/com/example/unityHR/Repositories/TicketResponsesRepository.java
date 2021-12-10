package com.example.unityHR.Repositories;

import com.example.unityHR.Models.TicketsResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketResponsesRepository extends JpaRepository<TicketsResponses, Integer> {

    List<TicketsResponses> findAllByticketid(int parseInt);
}

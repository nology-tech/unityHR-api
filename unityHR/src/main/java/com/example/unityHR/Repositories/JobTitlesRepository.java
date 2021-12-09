package com.example.unityHR.Repositories;


import com.example.unityHR.Models.JobTitles;
import com.example.unityHR.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitlesRepository extends JpaRepository<JobTitles, Integer> {
   // String deleteByid(int id);

}

package com.example.unityHR.Repositories;

import com.example.unityHR.Models.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RequestTypeRepository extends JpaRepository<RequestType, String> {

}

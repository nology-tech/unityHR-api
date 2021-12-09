package com.example.unityHR.Repositories;


import com.example.unityHR.Models.EmployeeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypesRepository extends JpaRepository<EmployeeTypes, String> {
}


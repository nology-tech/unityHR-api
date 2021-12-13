package com.example.unityHR.Repositories;

import com.example.unityHR.Models.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, String> {

}

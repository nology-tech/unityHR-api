package com.example.unityHR;

import com.example.unityHR.Models.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, String> {
}

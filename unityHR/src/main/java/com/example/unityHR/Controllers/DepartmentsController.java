package com.example.unityHR.Controllers;

import com.example.unityHR.DepartmentRepository;
import com.example.unityHR.Models.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentsController {
 @Autowired
    DepartmentRepository repository;

    ArrayList<Departments> departments = new ArrayList<>();



// GET all departments
@GetMapping("/departments")
public ResponseEntity<List<Departments>> getDepartments(){
    return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());

}

//POST a new department
@PostMapping("/department")
public ResponseEntity<String> addDepartment (@RequestBody Departments department) {
    repository.save(department);
return ResponseEntity.status(HttpStatus.CREATED).body("Department has been added");

}


}

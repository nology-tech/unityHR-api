package com.example.unityHR.Controllers;
import com.example.unityHR.Models.EmployeeTypes;
import com.example.unityHR.Repositories.EmployeeTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin (origins = "http://localhost:3000")
public class EmployeeTypesController {

    private ArrayList<EmployeeTypes> employeetypes = new ArrayList<>();
//    EmployeeTypes standardtypes= new EmployeeTypes("001","standard-employee");
//    EmployeeTypes hrtypes= new EmployeeTypes("002","hr-employee");
//    EmployeeTypes admintypes= new EmployeeTypes("002","admin-employee");
    @Autowired
    EmployeeTypesRepository repository;

    @PostMapping("/employeetypes")
    public ResponseEntity<String> createEmployeeTypes(@RequestBody EmployeeTypes employeetype)  {
            repository.save(employeetype);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee types added");
    }

    @GetMapping("/employeetype")
    public ResponseEntity<List<EmployeeTypes>> getEmployeeTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

}

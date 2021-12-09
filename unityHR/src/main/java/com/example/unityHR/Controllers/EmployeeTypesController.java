package com.example.unityHR.Controllers;
import com.example.unityHR.Models.EmployeeTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class EmployeeTypesController {

    private ArrayList<EmployeeTypes> employeetypes = new ArrayList<>();
//    EmployeeTypes standardtypes= new EmployeeTypes("001","standard-employee");
//    EmployeeTypes hrtypes= new EmployeeTypes("002","hr-employee");
//    EmployeeTypes admintypes= new EmployeeTypes("002","admin-employee");


    @PostMapping("/employeetypes")
    public ResponseEntity<String> createEmployeeTypes(@RequestBody EmployeeTypes employeetype)  {
            employeetypes.add(employeetype);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee types added");
    }

    @GetMapping("/employeetype")
    public ResponseEntity<ArrayList<EmployeeTypes>> getEmployeeTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(employeetypes);
    }


}

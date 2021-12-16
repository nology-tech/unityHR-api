package com.example.unityHR.Controllers;

import com.example.unityHR.Models.RequestType;
import com.example.unityHR.Repositories.RequestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://unityhr-d3bf1.web.app")
public class RequestTypeController {



    @Autowired
    RequestTypeRepository repository;

   @PostMapping("/request-type")
   public ResponseEntity<String> addRequestType(@RequestBody RequestType requestType){

    if (requestType.getRequestType().length() < 4) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request Type too short");
    } else {
        repository.save(requestType);
        System.out.println(requestType);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Request Type Added " + requestType.getRequestType());
    }

   }

   @GetMapping("/request-types")
    public ResponseEntity<List<RequestType>> getAllRequestTypes(){
       return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());

   }

//    private ArrayList<RequestType> newRequestTypes = new ArrayList<>();
//    private RequestType newRequestType = new RequestType();
//
//    @PostMapping("/reqtype")
//    public ResponseEntity<String> addNewRequestType(@RequestBody RequestType requestType){
//
//        if (requestType.getRequestType().length() < 4) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request Type too short");
//        } else {
//            newRequestTypes.add(newRequestType);
//            return ResponseEntity.status(HttpStatus.CREATED)
//                    .body("Request Type Added " + requestType.getRequestType());
//        }
//
//    }
//
//    @GetMapping("/reqtypes")
//    public ResponseEntity<List<RequestType>> getAllNewRequestTypes(){
//        return ResponseEntity.status(HttpStatus.OK).body(newRequestTypes);
//
//    }



}

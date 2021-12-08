package com.example.unityHR.Controllers;

import com.example.unityHR.Models.RequestType;
import com.example.unityHR.Repositories.RequestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class RequestTypeController {

    private ArrayList<RequestType> requestTypes = new ArrayList<>();

    @Autowired
    RequestTypeRepository repository;

   @PostMapping("/request-type")
   public ResponseEntity<String> addRequestType(@RequestBody RequestType requestType){

    if (requestType.getRequestType().length() < 4) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request Type too short");
    } else {
        repository.save(requestType);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Request Type Added " + requestType.getRequestType());
    }

   }

   @GetMapping("/request-types")
    public ResponseEntity<List<RequestType>> getAllRequestTypes(){
       return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());

   }


}

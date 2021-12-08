package com.example.unityHR.Controllers;
import com.example.unityHR.Models.JobTitles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

@RestController
public class JobTitlesController {
   private ArrayList<JobTitles> jobTitles = new ArrayList<>();

    //@Autowired
    //JobTitlesRepository repository;

    @GetMapping("/job-titles")
    public ResponseEntity<ArrayList<JobTitles>> getJobTitles() {
        String jobTitlesSizeHeaderValue = "Count: " + jobTitles.size();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("AllJobTitles",jobTitlesSizeHeaderValue)
                .body(jobTitles);
    }

    @PostMapping("/job-title")
    public ResponseEntity<String> createJobTitle(@RequestBody JobTitles jobTitle) {
        //String jobTitlesSizeHeaderValue = "Count: " + jobTitles.size();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Job Title Added", "1")
                .body(jobTitle.getJobTitle());
    }






}

//405 Method Not Allowed
//408 Request Timeout
//404 Not Found
//        400 Bad Request
//        The server could not understand the request due to invalid syntax.
//401 Unauthorized
//Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". That is, the client must authenticate itself to get the requested response.
// return ResponseEntity.ok().body(greetings);
//return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());




// 410 Gone
//414 URI Too Long

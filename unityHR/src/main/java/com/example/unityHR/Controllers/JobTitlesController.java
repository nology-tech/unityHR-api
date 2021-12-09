package com.example.unityHR.Controllers;
import com.example.unityHR.Models.JobTitles;
import com.example.unityHR.Repositories.JobTitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
public class JobTitlesController {
   private ArrayList<JobTitles> jobTitles = new ArrayList<>();

    @Autowired
    JobTitlesRepository jobTitlesRepository;

    @GetMapping("/job-titles")
    public ResponseEntity<List<JobTitles>> getJobTitles() {
        String jobTitlesSizeHeaderValue = "Count: " + jobTitles.size();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("AllJobTitles",jobTitlesSizeHeaderValue)
                .body(jobTitlesRepository.findAll());
    }

    @GetMapping("/job-title/{id}")
    public ResponseEntity<Optional<JobTitles>> getJobTitle(@PathVariable String id) {


            if(jobTitlesRepository.findById(parseInt(id)) !=null){
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .header("JobTitleId Found", "id: " + id)
                        .body(jobTitlesRepository.findById(parseInt(id)));
            } else{

                 return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("JobTitleId Not Found", "id: " + id)
                .body(null);

    }       }

    @PostMapping("/job-title")
    public ResponseEntity<String> createJobTitle(@RequestBody JobTitles jobTitle) {

        //jobTitles.add(jobTitle);
        jobTitlesRepository.save(jobTitle);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Job Title Added", "1")
                .body(jobTitle.getJobTitle());
    }

    @DeleteMapping("/job-title/{id}")
    public ResponseEntity<String> deleteJobTitle(@PathVariable String id) {


            if(jobTitlesRepository.findById(parseInt(id)) !=null){
                //jobTitles.remove(jobTitle);
                jobTitlesRepository.deleteById(parseInt(id));
                return ResponseEntity
                        .status(HttpStatus.GONE)
                        .header("JobTitleId Deleted", "id: " + id)
                        .body("JobTitle Deleted: " + id);
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .header("JobTitleId Not Found for deletion", "id: " + id)
                        .body("Id " + id + " not found");
            }
    }

    @PatchMapping("/job-title/{id}")
    public ResponseEntity<String> updateJobTitle(@PathVariable String id, @RequestBody String title) {

//        JobTitles jobTitle = jobTitlesRepository
//                .findById(parseInt(id)).orElseThrow();
            if(jobTitlesRepository.findById(parseInt(id)) !=null){
                JobTitles jobTitle = jobTitlesRepository
                        .findById(parseInt(id)).orElseThrow();
                jobTitle.setJobTitle(title);
                jobTitlesRepository.save(jobTitle);

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .header("JobTitle updated", "id: " + id)
                        .body("JobTitle updated: " + jobTitle);
            } else {

                return ResponseEntity
                        .status(HttpStatus.NOT_MODIFIED)
                        .header("JobTitleId Not Found to update ", "id: " + id)
                        .body("Id " + id + " not found to update");
            }
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

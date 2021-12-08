package com.example.unityHR.Controllers;
import com.example.unityHR.Models.User;
import com.example.unityHR.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private ArrayList<User> users = new ArrayList<>();

//    @Autowired(required=false)
//    UserRepository userRepo;
    //Add user method
    @PostMapping ("User/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user ){
        users.add(user);
       // userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("User added sucessfully");
    }
    //Fetch all users  method
    @GetMapping ("User/getAllUsers")
    public ResponseEntity<List<User>> getUsers(){
     return  ResponseEntity.status(HttpStatus.OK).body(users);
     //  return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
    }

    @GetMapping ("User/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
       return  ResponseEntity.status(HttpStatus.OK).body(users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null));
    //return ResponseEntity.status(HttpStatus.OK).body(userRepo.findById(userId));
    }

    //Delete single user method
    @DeleteMapping("User/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
      //  userRepo.deleteById(id);
        users.removeIf(user -> user.getId().equals(id));
       return ResponseEntity.status(HttpStatus.GONE).body("User Deleted Successfully" + id);
    }
    //Update user method

   //Bulk delete
    @PostMapping("/User/deleteUsers")
    private ResponseEntity<String> deleteEmployees(@RequestBody ArrayList<String> userlist){
      //  userRepo.deleteAllById(userlist);
       return ResponseEntity.status(HttpStatus.GONE).body("Bulk delete successfull");
    }



}

package com.example.unityHR.Controllers;
import com.example.unityHR.Models.User;
//import com.example.unityHR.Repositories.UserRepository;
import com.example.unityHR.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class UserController {
    private ArrayList<User> users = new ArrayList<>();

  @Autowired(required=false)
  UserRepository userRepo;
    //Add user method
    @PostMapping ("User/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user ){
       // users.add(user);
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("User added sucessfully");
    }
    //Fetch all users  method
    @GetMapping ("User/getAllUsers")
    public ResponseEntity<Iterable<User>> getUsers(){
     //return  ResponseEntity.status(HttpStatus.OK).body(users);
     return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
    }

    @GetMapping ("User/{userFirebaseId}")
    public ResponseEntity<User> getUser(@PathVariable String userFirebaseId){
    //   return  ResponseEntity.status(HttpStatus.OK).body(users.stream().filter(user -> user.getFirebaseId().equals(userId)).findFirst().orElse(null));
    return ResponseEntity.status(HttpStatus.OK).body(userRepo.getByFirebaseId(userFirebaseId));
    }

    //Delete single user method
    @DeleteMapping("User/{userFirebaseId}")
    @Transactional
    public ResponseEntity<String> deleteUser(@PathVariable String userFirebaseId){
       userRepo.deleteByFirebaseId(userFirebaseId);
      //  users.removeIf(user -> user.getFirebaseId().equals(id));
       return ResponseEntity.status(HttpStatus.GONE).body("User Deleted Successfully" + userFirebaseId);
    }
    //Update user method
    @DeleteMapping("User/email/{email}")
    @Transactional
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email){
        userRepo.deleteByEmailVerified(email);
        //  users.removeIf(user -> user.getFirebaseId().equals(id));
        return ResponseEntity.status(HttpStatus.GONE).body("User Deleted Successfully" + email);
    }
   //Bulk delete
    @PostMapping("/User/deleteUsers")
    private ResponseEntity<String> deleteEmployees(@RequestBody ArrayList<String> userlist){
       userRepo.deleteAllById(userlist);
       return ResponseEntity.status(HttpStatus.GONE).body("Bulk delete successfull");
    }



}

package com.example.unityHR.Controllers;
import com.example.unityHR.Models.User;
import com.example.unityHR.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private ArrayList<User> users = new ArrayList<>();

    @Autowired(required=false)
    UserRepository userRepo;
    //Add user method
    @PostMapping ("User/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user ){
        users.add(user);
        return ResponseEntity.status(HttpStatus.OK).body("User added sucessfully");
    }
    //Fetch all users  method
    @GetMapping ("User/getAllUsers")
    public ResponseEntity<List<User>> getUsers(){
      return  ResponseEntity.status(HttpStatus.OK).body(users);
       // return ResponseEntity.status(HttpStatus.OK).body(respository.findAll());
    }

    @GetMapping ("User/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        return  ResponseEntity.status(HttpStatus.OK).body(users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null));
    }

    //Delete single user method
    @DeleteMapping("User/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        users.removeIf(user -> user.getId().equals(id));
       // users.remove(id);
        return ResponseEntity.status(HttpStatus.GONE).body("User Deleted Successfully" + id);
    }
    //Update user method

   //Bulk delete
    @PostMapping("/User/deleteUsers")
    private void deleteEmployees(@RequestBody ArrayList<User> userlist){
        userlist.forEach(user -> users.remove(user.getId()));
        //users.removeIf(user -> user.getId() == id);
       // users.remove(id);
    }



}

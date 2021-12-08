package com.example.unityHR.Controllers;
import com.example.unityHR.Models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class UserController {
    private ArrayList<User> users = new ArrayList<>();

    //Add user method
    @PostMapping ("User/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user ){
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Added new user successfully");
    }

    //Fetch all users  method
    @GetMapping ("User/getAllUsers")
    public ResponseEntity <ArrayList<User>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    //Update user method

    //Delete single user method
    @DeleteMapping("/User/{id}")
    public ResponseEntity<String> deleteUser(@RequestBody String id){
        users.removeIf(user -> user.getId() == id);
            users.remove(id);
            return ResponseEntity.status(HttpStatus.GONE).body("User Deleted Successfully" + id);
    }

    //Bulk delete


    }



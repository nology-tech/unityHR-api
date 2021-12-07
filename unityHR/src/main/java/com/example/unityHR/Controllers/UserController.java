package com.example.unityHR.Controllers;
import com.example.unityHR.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class UserController {
    private ArrayList<User> users = new ArrayList<>();

    //Add user method
    @PostMapping ("User/addUser")
    public void addUser(@RequestBody User user ){
        users.add(user);

    }
    //Fetch all users  method
    @GetMapping ("User/getAllUsers")
    public ArrayList<User> getUsers(){
        return users;
    }

    //Update user method

    //Delete single user method
    @DeleteMapping("/User/{id}")
    private void deleteEmployee(@RequestBody String id){
        users.removeIf(user -> user.getId() == id);
            users.remove(id);
    }

    //Bulk delete


    }

}

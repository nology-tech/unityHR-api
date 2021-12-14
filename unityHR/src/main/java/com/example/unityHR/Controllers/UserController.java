package com.example.unityHR.Controllers;
import com.example.unityHR.Models.User;
//import com.example.unityHR.Repositories.UserRepository;
import com.example.unityHR.Repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private ArrayList<User> users = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(UserController.class);

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
    public ResponseEntity<List<User>> getUsers(){
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
    public ResponseEntity<String> deleteUser(@PathVariable String userFirebaseId){
       userRepo.deleteById(userFirebaseId);
      //  users.removeIf(user -> user.getFirebaseId().equals(id));
       return ResponseEntity.status(HttpStatus.GONE).body("User Deleted Successfully" + userFirebaseId);
    }
    //Update user method

   //Bulk delete
    @PostMapping("/User/deleteUsers")
    private ResponseEntity<String> deleteEmployees(@RequestBody ArrayList<String> userlist){
       userRepo.deleteAllById(userlist);
       return ResponseEntity.status(HttpStatus.GONE).body("Bulk delete successfull");
    }

//    private User applyPatchToCustomer(
//            JsonPatch patch, User targetUser) throws JsonPatchException, JsonProcessingException {
//        JsonNode patched = patch.apply(objectMapper.convertValue(targetUser, JsonNode.class));
//        return objectMapper.treeToValue(patched, Customer.class);
//    }

    //Patch User
//
//    @PatchMapping("/User/{emailVerified}")
//    @Transactional
//    public ResponseEntity<User> updateEmployees(@PathVariable String emailVerified, @RequestBody User user){
//
//        logger.error(emailVerified);
//        logger.error(emailVerified,user);
//
//        User existingUser = userRepo.getByEmailVerified(emailVerified);
//
//        logger.error(existingUser.getUUIDUser().toString());
//
//     if (existingUser != null) {
//          userRepo.updateMobileByFirebaseId(emailVerified, user.getFirstName(),user.getLastName(),user.getPronoun(), user.getAddress(), user.getMobileNo());
//        }
//
//        User updatedUser = userRepo.getByEmailVerified(emailVerified);
//
//       // return ResponseEntity.status(HttpStatus.OK).body("user updated");
//
//
//        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
//    }

    @PatchMapping("/User/{emailVerified}/{updatedFieldName}")
    @Transactional
    public ResponseEntity<User> updateEmployeeDetail(@PathVariable String emailVerified, @PathVariable String updatedFieldName, @RequestBody String updatedFieldValue){

        logger.error(emailVerified);
        logger.error(updatedFieldName);
        logger.error(updatedFieldValue);

        User existingUser = userRepo.getByEmailVerified(emailVerified);

        logger.error(existingUser.getUUIDUser().toString());

        if (existingUser != null) {

            switch (updatedFieldName) {
                case "firstName":
                    userRepo.updateMobileByFirebaseId(emailVerified, updatedFieldValue,existingUser.getLastName(),existingUser.getPronoun(), existingUser.getAddress(), existingUser.getMobileNo());
                    break;
                case "lastName":
                    userRepo.updateMobileByFirebaseId(emailVerified, existingUser.getFirstName(),updatedFieldValue,existingUser.getPronoun(), existingUser.getAddress(), existingUser.getMobileNo());
                    break;
                case "pronoun":
                    userRepo.updateMobileByFirebaseId(emailVerified, existingUser.getFirstName(),existingUser.getLastName(), updatedFieldValue, existingUser.getAddress(), existingUser.getMobileNo());
                    break;
                case "address":
                    userRepo.updateMobileByFirebaseId(emailVerified, existingUser.getFirstName(), existingUser.getLastName(), existingUser.getPronoun(), updatedFieldValue, existingUser.getMobileNo());
                    break;
                case "mobileNo":
                    userRepo.updateMobileByFirebaseId(emailVerified, existingUser.getFirstName(), existingUser.getLastName(),existingUser.getPronoun(), existingUser.getAddress(), updatedFieldValue);
                    break;
                default:
                    break;
            }
            //existingUser.setMobileNo(updatedFieldValue);

        }

        User updatedUser = userRepo.getByEmailVerified(emailVerified);

        // return ResponseEntity.status(HttpStatus.OK).body("user updated");


        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }



}

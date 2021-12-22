package com.example.unityHR.Controllers;
import com.example.unityHR.Models.JobTitles;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
//@CrossOrigin (origins = "https://unityhr-d3bf1.web.app")
@CrossOrigin
public class UserController {
    private ArrayList<User> users = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired(required=false)
  UserRepository userRepo;
    //Add user method
    @PostMapping ("/User")
    public ResponseEntity<String> addUser(@RequestBody User user ){
       // users.add(user);
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("User added sucessfully");
    }

    @PutMapping ("User/{userFirebaseId}")
    public ResponseEntity<String> updateUser(@PathVariable String userFirebaseId ,@RequestBody User user ){
        // users.add(user);
        if(userRepo.getByFirebaseId(userFirebaseId) !=null){
            User databaseUser = userRepo
                    .getByFirebaseId(userFirebaseId);
            databaseUser.setFirstName(user.getFirstName());
            databaseUser.setLastName(user.getLastName());
            databaseUser.setEmailVerified(user.getEmailVerified());
            databaseUser.setJobTitle(user.getJobTitle());
            databaseUser.setDepartment(user.getDepartment());
            databaseUser.setType(user.getType());
            userRepo.save(databaseUser);
            return ResponseEntity
                    .status(HttpStatus.OK)
                      .body("User updated: " + user);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_MODIFIED)
                  //  .header("JobTitleId Not Found to update ", "id: " + id)
                    .body("USer"+ user+" not found to update");
        }

    }

    //Fetch all users  method
    @GetMapping ("/Users")
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
         return ResponseEntity.status(HttpStatus.GONE).body("User Deleted Successfully" + email);
    }
   //Bulk delete
    @DeleteMapping("Users")
    @Transactional
    private ResponseEntity<String> deleteEmployees(@RequestBody ArrayList<String> userList){
      // userRepo.deleteAllById(userlist);
      userList.stream().forEach(user->deleteUser(user));//
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

       // logger.error(existingUser.getUUIDUser().toString());

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

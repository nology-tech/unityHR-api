package com.example.unityHR.Repositories;

import com.example.unityHR.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
   User getByFirebaseId(String firebaseId);
   @Modifying
   @Query(value = "DELETE FROM User  WHERE FIREBASE_ID = :firebaseId")       // it will delete all the record with specific name
  void deleteByFirebaseId(@Param("firebaseId") String firebaseId);
   @Modifying
   @Query(value = "DELETE FROM User  WHERE email_verified = :email")
   void deleteByEmailVerified(@Param("email") String email);
}

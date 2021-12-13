package com.example.unityHR.Repositories;

import com.example.unityHR.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
   User getByFirebaseId(String firebaseId);
}

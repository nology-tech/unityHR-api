package com.example.unityHR.Repositories;

import com.example.unityHR.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
   User getByFirebaseId(String firebaseId);
   User getByEmailVerified(String emailVerified);


   @Modifying(clearAutomatically = true)
   @Query("UPDATE User SET  first_name = :firstName, last_name = :lastName, pronoun = :pronoun, address = :address, mobile_no = :mobileNo WHERE email_verified = :emailVerified")

   void updateMobileByFirebaseId(@Param("emailVerified") String emailVerified, @Param("firstName") String firstName,
                                 @Param("lastName") String lastName,
                                 @Param("pronoun") String pronoun,
                                 @Param("address") String address,
                                 @Param("mobileNo") String mobileNo );
}

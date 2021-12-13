package com.example.unityHR.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID UUIDUser;
    private String firebaseId;
    private String pronoun;
    private String firstName;
    private String lastName;
    private String address;
    private String emailVerified;
    private String type;
    private String jobTitle;
    private int mobileNo;
    private String department;
    private String profileImage;
    private String theme;
    //private boolean active;




    public User(){};
    //Called from Add user form
    public User ( String firstName, String lastName, String emailVerified,
                 String type, String jobTitle,  String department,String firebaseId) {
        this.firebaseId = firebaseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailVerified = emailVerified;
        this.type = type;
        this.jobTitle = jobTitle;
        this.department = department;
        //this.active=true;


    }
    public User (String firebaseId, String pronoun, String firstName, String lastName, String address, String emailVerified,
                 String type, String jobTitle, int mobileNo, String department, String profileImage, String theme) {
        this.firebaseId = firebaseId;
        this.pronoun = pronoun;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailVerified = emailVerified;
        this.type = type;
        this.jobTitle = jobTitle;
        this.mobileNo = mobileNo;
        this.department = department;
        this.profileImage = profileImage;
        this.theme = theme;
        //this.active =true;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(String createdOn) {
//        this.createdOn = createdOn;
//    }
//
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    public String getUpdatedOn() {
//        return updatedOn;
//    }
//
//    public void setUpdatedOn(String updatedOn) {
//        this.updatedOn = updatedOn;
//    }
}





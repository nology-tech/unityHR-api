package com.example.unityHR.Models;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class User {
    private String id;
    private String pronoun;
    private String firstName;
    private String lastName;
    private String address;
    private String emailVerified;
    private String type;
    private String jobTitle;
    private long mobile;
    private String department;
    private String profileImage;
    private String theme;
    private String createdBy;
    private String createdOn;
    private String updatedBy;
    private String updatedOn;

    public User (String id, String pronoun, String firstName, String lastName, String address, String emailVerified,
                 String type, String jobTitle, long mobile, String department, String profileImage, String theme) {
        this.id = id;
        this.pronoun = pronoun;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailVerified = emailVerified;
        this.type = type;
        this.jobTitle = jobTitle;
        this.mobile = mobile;
        this.department = department;
        this.profileImage = profileImage;
        this.theme = theme;
    }

        public String getId(){
        return getId();
        }

        public String getType() {
            return type;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public String getDepartment() {
            return department;
        }


    }





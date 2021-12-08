package com.example.unityHR.Models;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String requestType;
    private String title;
    private String description;
    private String status;
    private String department;
    private ArrayList<Response> responses;
    private String assignee;
    private String responseOn;
    private String createdBy;
    private String createdOn;
    private String updatedBy;
    private String updatedOn;

    public Ticket(String requestType, String title, String description) {
        this.requestType = requestType;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }
}

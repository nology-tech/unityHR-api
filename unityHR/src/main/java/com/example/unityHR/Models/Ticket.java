package com.example.unityHR.Models;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String requestType;
    private String title;
    private String description;
    private String status;
    private String createdBy;
    private Timestamp createdOn;

    public Ticket() {
        this.createdOn = new Timestamp(new Date().getTime());
    }

    public Ticket(String requestType, String title, String description) {
        this.requestType = requestType;
        this.title = title;
        this.description = description;
        this.createdOn = new Timestamp(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", requestType='" + requestType + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn='" + createdOn + '\'' +
                '}';
    }
}

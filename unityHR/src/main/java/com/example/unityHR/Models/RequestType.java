package com.example.unityHR.Models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;


@Entity
public class RequestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String requestType;
    private String theme;
    private String createdBy;
    private Timestamp createdOn;

    public RequestType() {
        Date date = new Date();
        this.createdOn = new Timestamp(date.getTime());
    }


    public RequestType(String requestType, String theme, String createdBy) {
        this.requestType = requestType;
        this.theme = theme;
        this.createdBy = createdBy;
        Date date = new Date();
        this.createdOn = new Timestamp(date.getTime());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
}

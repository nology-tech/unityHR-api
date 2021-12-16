package com.example.unityHR.Models;

import java.sql.Timestamp;
import java.util.Date;

public class Response {
    private String ticketID;
    private String response;
    private String updatedBy;
    private Date updatedOn;

    public Response(String ticketID, String response, String updatedBy) {
        this.ticketID = ticketID;
        this.response = response;
        this.updatedBy = updatedBy;
        this.updatedOn = new Timestamp(new Date().getTime());
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getResponse() {
        return response;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }
}
package com.example.unityHR.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class TicketsResponses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketResponsesId;
    private int ticketid;
    private String responseText;
    private String updatedBy;
    private Timestamp updatedOn;

    public TicketsResponses(int ticketId, String responseText, String updatedBy) {
        this.ticketid = ticketId;
        this.responseText = responseText;
        this.updatedBy = updatedBy;
        this.updatedOn = new Timestamp(new Date().getTime());
    }

    public TicketsResponses() {
        this.updatedOn = new Timestamp(new Date().getTime());
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

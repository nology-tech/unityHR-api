package com.example.unityHR.Models;

import java.sql.Timestamp;
import java.util.Date;

public class Tickets_Responses {
    private int ticketId;
    private int responseId;
    private String responseText;
    private String updatedBy;
    private Timestamp updatedOn;

    public Tickets_Responses(int ticketId, int responseId, String responseText, String updatedBy, Timestamp updatedOn) {
        this.ticketId = ticketId;
        this.responseId = responseId;
        this.responseText = responseText;
        this.updatedBy = updatedBy;
        this.updatedOn = new Timestamp(new Date().getTime());
    }

    public Tickets_Responses() {
        this.updatedOn = new Timestamp(new Date().getTime());
    }
}

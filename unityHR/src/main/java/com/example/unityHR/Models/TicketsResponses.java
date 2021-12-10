package com.example.unityHR.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Tickets_Responses {
    @Id
    private int ticketResponsesId;
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

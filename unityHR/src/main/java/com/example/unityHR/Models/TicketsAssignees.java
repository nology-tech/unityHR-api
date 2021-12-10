package com.example.unityHR.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tickets_Assignees {
    @Id
    private int ticketAssigneeId;
    private int ticketID;
    private String emailVerified;

    public Tickets_Assignees() {
    }

    public Tickets_Assignees(int ticketID, String emailVerified) {
        this.ticketID = ticketID;
        this.emailVerified = emailVerified;
    }

}

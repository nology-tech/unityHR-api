package com.example.unityHR.Models;

public class Tickets_Assignees {
    private int ticketID;
    private String emailVerified;

    public Tickets_Assignees() {
 }

    public Tickets_Assignees(int ticketID, String emailVerified) {
        this.ticketID = ticketID;
        this.emailVerified = emailVerified;
    }

}

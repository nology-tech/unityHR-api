package com.example.unityHR.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketsAssignees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketAssigneeId;
    private int ticketid;
    private String emailVerified;

    public TicketsAssignees() {
    }

    public TicketsAssignees(int ticketID, String emailVerified) {
        this.ticketid = ticketID;
        this.emailVerified = emailVerified;
    }

    @Override
    public String toString() {
        return "TicketsAssignees{" +
                "ticketAssigneeId=" + ticketAssigneeId +
                ", ticketid=" + ticketid +
                ", emailVerified='" + emailVerified + '\'' +
                '}';
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }
}

package com.example.unityHR.DTO;

import com.example.unityHR.Models.Ticket;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TicketDTO {
    private int id;
    private String requestType;
    private String title;
    private String decsription;
    private String status;
    private String createdBy;
    private Timestamp createdOn;
    private List<String> assignees;
    private List<TicketResponseDTO> responses;

    public void setId(int id) {
        this.id = id;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDecsription(String decsription) {
        this.decsription = decsription;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public void setAssignees(List<String> assignees) {
        this.assignees = assignees;
    }

    public void setResponses(List<TicketResponseDTO> responses) {
        this.responses = responses;
    }

    public int getId() {
        return id;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getTitle() {
        return title;
    }

    public String getDecsription() {
        return decsription;
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

    public List<String> getAssignees() {
        return assignees;
    }

    public List<TicketResponseDTO> getResponses() {
        return responses;
    }

    public static class TicketResponseDTO{
        private String responseText;
        private String updatedBy;
        private Timestamp updatedOn;

        public void setResponseText(String responseText) {
            this.responseText = responseText;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public void setUpdatedOn(Timestamp updatedOn) {
            this.updatedOn = updatedOn;
        }

        public String getResponseText() {
            return responseText;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public Timestamp getUpdatedOn() {
            return updatedOn;
        }
    }
}

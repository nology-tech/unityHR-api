package com.example.unityHR.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobTitles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
    private String name;

    public JobTitles(String name) {

          this.name = name;
    }

    public JobTitles() {
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JobTitles{" +
                "jobTitleId='" + Id + '\'' +
                ", jobTitle='" + name + '\'' +
                '}';
    }
}

package com.example.unityHR.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobTitles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String jobTitleId;
    private String jobTitle;

    public JobTitles(String jobTitle) {
          this.jobTitle = jobTitle;
    }

    public String getJobTitleId() {
        return jobTitleId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return "JobTitles{" +
                "jobTitleId='" + jobTitleId + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}

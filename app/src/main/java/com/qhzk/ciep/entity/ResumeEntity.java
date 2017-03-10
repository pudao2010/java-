package com.qhzk.ciep.entity;

import java.util.List;

/**
 * Created by pucheng on 2017/1/5.
 * Rxjava + retrofit来的
 */

public class ResumeEntity {

    private String createDate;
    private String id;
    private String name;
    private String userid;
    private List<Education> educationList;
    private List<JobPreferences> jobPreferences;
    private List<WorkExperience> workExperienceList;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<JobPreferences> getJobPreferences() {
        return jobPreferences;
    }

    public void setJobPreferences(List<JobPreferences> jobPreferences) {
        this.jobPreferences = jobPreferences;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }
}

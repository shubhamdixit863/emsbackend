package com.ems.employemanagement.models;

import com.ems.employemanagement.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
public class TimesheetRequest {

    @Override
    public String toString() {
        return "TimesheetRequest{" +
                "id=" + id +
                ", taskDone='" + taskDone + '\'' +
                ", loggedInTime='" + loggedInTime + '\'' +
                ", logoutTime='" + logoutTime + '\'' +

                ", entryDate=" + entryDate +
                '}';
    }
    @NotNull
    @NotEmpty
    private String taskDone;
    @NotNull
    @NotEmpty
    private String loggedInTime;
    @NotNull
    @NotEmpty
   private String logoutTime;
    private Long id;
    @NotNull
    @NotEmpty
    private Date entryDate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskDone() {
        return taskDone;
    }

    public void setTaskDone(String taskDone) {
        this.taskDone = taskDone;
    }

    public String getLoggedInTime() {
        return loggedInTime;
    }

    public void setLoggedInTime(String loggedInTime) {
        this.loggedInTime = loggedInTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}

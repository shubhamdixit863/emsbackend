package com.ems.employemanagement.models;

import com.ems.employemanagement.util.Roles;

import javax.persistence.Column;
import java.sql.Date;

public class EmployeeRequest {
    private String name;
    private long id;

    private String username;

    private boolean isEnabled;

    private Roles role;

    private String Address;

    private String joiningDate;

    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", isEnabled=" + isEnabled +
                ", role=" + role +
                ", Address='" + Address + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

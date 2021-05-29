package com.ems.employemanagement.models;

import com.ems.employemanagement.util.Roles;
import org.springframework.data.domain.Sort;

public class EmployeeFilterRequest {
    private int pageNumber=0;
    private int pageSize=10;
    private Sort.Direction sortDirection=Sort.Direction.ASC;
    private String sortBy="id";
    private String name;
    private String userName;
    private boolean isEnabled;
    private String Address;

    private String joiningDate;

    private String password;

    @Override
    public String toString() {
        return "EmployeeFilterRequest{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", sortDirection=" + sortDirection +
                ", sortBy='" + sortBy + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", isEnabled=" + isEnabled +

                ", Address='" + Address + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
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
}

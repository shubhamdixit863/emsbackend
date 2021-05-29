package com.ems.employemanagement.controllers;

import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.models.EmployeeFilterRequest;
import com.ems.employemanagement.models.EmployeePage;
import com.ems.employemanagement.models.EmployeeRequest;
import com.ems.employemanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping("/createEmployee")
    public User createUser(@RequestBody EmployeeRequest employeeRequest)
    {
        return userService.createUser(employeeRequest);
    }

    @PostMapping ("/employeeList")
    public ResponseEntity<Page<User>> getEmploye(@RequestBody EmployeePage employeePage)
    {

       return new ResponseEntity<>(userService.getEmployees(employeePage), HttpStatus.OK);
    }

    @PostMapping ("/employeeListFilter")
    public ResponseEntity<Page<User>> getEmployeFilter(@RequestBody EmployeeFilterRequest employeeFilterRequest)
    {

        return new ResponseEntity<>(userService.getEmployeesByCriteria(employeeFilterRequest), HttpStatus.OK);
    }
}

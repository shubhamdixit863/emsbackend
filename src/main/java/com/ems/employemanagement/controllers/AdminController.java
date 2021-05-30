package com.ems.employemanagement.controllers;

import com.ems.employemanagement.entity.Timesheet;
import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.models.EmployeeFilterRequest;
import com.ems.employemanagement.models.PageInfo;
import com.ems.employemanagement.models.EmployeeRequest;
import com.ems.employemanagement.services.TimesheetService;
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
    @Autowired
    private TimesheetService timesheetService;

    @PostMapping("/createEmployee")
    public ResponseEntity<User> createUser(@RequestBody EmployeeRequest employeeRequest)
    {
        System.out.println(employeeRequest.toString());
        try{
            return  new ResponseEntity<>(userService.createUser(employeeRequest),HttpStatus.OK);


        }

        catch (Exception e)
        {
            return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping ("/employeeList")
    public ResponseEntity<Page<User>> getEmploye(@RequestBody PageInfo pageInfo)
    {

       return new ResponseEntity<>(userService.getEmployees(pageInfo), HttpStatus.OK);
    }

    @PostMapping ("/employeeListFilter")
    public ResponseEntity<Page<User>> getEmployeFilter(@RequestBody EmployeeFilterRequest employeeFilterRequest)
    {

        return new ResponseEntity<>(userService.getEmployeesByCriteria(employeeFilterRequest), HttpStatus.OK);
    }

    @PostMapping ("/deleteEmployee")
    public ResponseEntity<Page<User>> deleteEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        userService.deleteUser(employeeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/getTimesheet")
    public ResponseEntity<Page<Timesheet>> getTimesheet(@RequestBody PageInfo pageInfo)
    {
        return new ResponseEntity<>(timesheetService.getTimesheets(pageInfo),HttpStatus.OK);
    }

    @PostMapping("/updateEmployeeAdmin")
    public ResponseEntity<User> updateEmployeeAdmin(@RequestBody EmployeeRequest employeeRequest)
    {
        try{
            System.out.println(employeeRequest.toString());

            return new ResponseEntity<>(userService.updateEmployeeAdmin(employeeRequest),HttpStatus.OK);

        }

        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        }
    }
}

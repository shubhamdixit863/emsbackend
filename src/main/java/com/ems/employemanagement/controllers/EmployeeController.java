package com.ems.employemanagement.controllers;

import com.ems.employemanagement.entity.Timesheet;
import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.models.EmployeeRequest;
import com.ems.employemanagement.models.PageInfo;
import com.ems.employemanagement.models.TimesheetRequest;
import com.ems.employemanagement.services.TimesheetService;
import com.ems.employemanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private UserService userService;

    @PostMapping("/timeSheetEntry")
    public ResponseEntity<Timesheet> timeSheetEntry(@RequestBody TimesheetRequest timesheetRequest, Principal principal)
    {
        System.out.println(timesheetRequest.toString());
        return new ResponseEntity<>(timesheetService.addTimeSheet(timesheetRequest,principal.getName()), HttpStatus.OK);

    }

    @PostMapping("/getUserTimeSheet")
    public ResponseEntity<Page<Timesheet>> getUserTimeSheet(@RequestBody PageInfo pageInfo, Principal principal)
    {

        String username=principal.getName();
        System.out.println(username);
        return new ResponseEntity<>(timesheetService.getTimeSheetByUserId(pageInfo,username), HttpStatus.OK);

    }

    @PostMapping("/updateEmployee")
    public ResponseEntity<User> updateEmplyee(@RequestBody EmployeeRequest employeeRequest, Principal principal)
    {

        String username=principal.getName();
        System.out.println(username);
        return new ResponseEntity<>(userService.updateUser(employeeRequest,username) ,HttpStatus.OK);

    }

    @PostMapping("/getByUsername")
    public ResponseEntity<User> updateEmplyee(Principal principal)
    {

        String username=principal.getName();
        System.out.println(username);
        return new ResponseEntity<>(userService.getUserByUsername(username) ,HttpStatus.OK);

    }
}

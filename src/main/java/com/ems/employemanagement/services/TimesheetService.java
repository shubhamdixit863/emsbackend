package com.ems.employemanagement.services;

import com.ems.employemanagement.entity.Timesheet;
import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.models.PageInfo;
import com.ems.employemanagement.models.TimesheetRequest;
import com.ems.employemanagement.repositories.TimeSheetRepository;
import com.ems.employemanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TimesheetService {

    @Autowired
    private TimeSheetRepository timeSheetRepository;
    @Autowired
    private UserRepository userRepository;


    public Page<Timesheet> getTimesheets(PageInfo pageInfo)
    {
        Sort sort=Sort.by(pageInfo.getSortDirection(), pageInfo.getSortBy());
        Pageable pageable= PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(),sort);
        return timeSheetRepository.findAll(pageable);
    }

    public Timesheet addTimeSheet(TimesheetRequest timesheetRequest,String username)
    {
        Timesheet timesheet=new Timesheet();
        timesheet.setTaskDone(timesheetRequest.getTaskDone());
        timesheet.setUser(userRepository.findByUsername(username));
        timesheet.setLogoutTime(timesheetRequest.getLogoutTime());
        timesheet.setLoggedInTime(timesheetRequest.getLoggedInTime());
        timesheet.setEntryDate(timesheetRequest.getEntryDate());
        return timeSheetRepository.save(timesheet);

    }

    public Page<Timesheet> getTimeSheetByUserId(PageInfo pageInfo,String username)
    {
        Sort sort=Sort.by(pageInfo.getSortDirection(), pageInfo.getSortBy());
        Pageable pageable= PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(),sort);
        User user= userRepository.findByUsername(username);
        return timeSheetRepository.findByUser(user,pageable);
    }
}

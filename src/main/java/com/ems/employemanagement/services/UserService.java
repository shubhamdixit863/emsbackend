package com.ems.employemanagement.services;

import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.models.EmployeeFilterRequest;
import com.ems.employemanagement.models.PageInfo;
import com.ems.employemanagement.models.EmployeeRequest;
import com.ems.employemanagement.models.UserCreationRequest;
import com.ems.employemanagement.repositories.UserRepository;
import com.ems.employemanagement.util.UserSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserByUsername(String username)
    {
        return  userRepository.findByUsername(username);
    }

    public User createUser(UserCreationRequest userCreationRequest)
    {
       User user=new User();
       user.setEnabled(true);
       user.setRole(userCreationRequest.getRole().name());
       user.setUsername(userCreationRequest.getUsername());
       user.setPassword(bCryptPasswordEncoder.encode(userCreationRequest.getPassword()));
       user.setName(userCreationRequest.getName());
       return userRepository.save(user);

    }

    public User createUser(EmployeeRequest employeeRequest)
    {
        System.out.println(employeeRequest.toString());
        User user=new User();
        user.setEnabled(true);
        user.setRole(employeeRequest.getRole().name());
        user.setUsername(employeeRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(employeeRequest.getPassword()));
        user.setName(employeeRequest.getName());
        user.setAddress(employeeRequest.getAddress());
        user.setJoiningDate(Date.valueOf(employeeRequest.getJoiningDate()));
        return userRepository.save(user);

    }

    public User updateUser(EmployeeRequest employeeRequest,String username)
    {
        User user=userRepository.findByUsername(username);
        user.setEnabled(true);

        user.setUsername(employeeRequest.getUsername());
        if(employeeRequest.getPassword()!=null)
        {
            user.setPassword(bCryptPasswordEncoder.encode(employeeRequest.getPassword()));

        }
        user.setName(employeeRequest.getName());
        user.setAddress(employeeRequest.getAddress());
        user.setJoiningDate(Date.valueOf(employeeRequest.getJoiningDate()));
        return userRepository.save(user);
    }

    public Page<User> getEmployees(PageInfo pageInfo)
    {
        Sort sort=Sort.by(pageInfo.getSortDirection(), pageInfo.getSortBy());
        Pageable pageable= PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(),sort);
        return userRepository.findAll(pageable);
    }

    public Page<User> getEmployeesByCriteria(EmployeeFilterRequest employeeFilterRequest)
    {
        Sort sort=Sort.by(employeeFilterRequest.getSortDirection(),employeeFilterRequest.getSortBy());
        Pageable pageable= PageRequest.of(employeeFilterRequest.getPageNumber(),employeeFilterRequest.getPageSize(),sort);
        return userRepository.findAll(UserSpecs.getUserByIdUserNameNameAddress(employeeFilterRequest),pageable);
    }

    public void deleteUser(EmployeeRequest employeeRequest)
    {
        this.userRepository.deleteById(employeeRequest.getId());
    }

}

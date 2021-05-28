package com.ems.employemanagement.services;

import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.models.UserCreationRequest;
import com.ems.employemanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}

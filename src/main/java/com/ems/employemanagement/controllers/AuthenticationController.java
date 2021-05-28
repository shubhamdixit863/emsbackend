package com.ems.employemanagement.controllers;

import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.models.AuthenticateRequest;
import com.ems.employemanagement.models.AuthenticateResponse;
import com.ems.employemanagement.models.UserCreationRequest;
import com.ems.employemanagement.security.CustomUserDetailsService;
import com.ems.employemanagement.security.JwtUtilService;
import com.ems.employemanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtilService jwtUtilService;
    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(),authenticateRequest.getPassword()));
        }
        catch (BadCredentialsException badCredentialsException)
        {
         throw  new Exception("Wrong UserName Password");
        }
        final UserDetails userDetails= customUserDetailsService.loadUserByUsername(authenticateRequest.getUserName());
        final String jwt=jwtUtilService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@RequestBody UserCreationRequest userCreationRequest)
    {
      User user= userService.createUser(userCreationRequest);
      return ResponseEntity.ok(user);

    }

}

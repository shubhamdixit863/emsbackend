package com.ems.employemanagement.security;

import java.util.ArrayList;
import java.util.List;

import com.ems.employemanagement.entity.User;
import com.ems.employemanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService userservice;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userservice.getUserByUsername(username);
		if(user != null && user.isEnabled()) {
			List<GrantedAuthority> roleList=new ArrayList<>();
			roleList.add(new SimpleGrantedAuthority(user.getRole()));
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),roleList);
		}
		else {
		        throw new UsernameNotFoundException("username not found");
		    }
		
	}


}
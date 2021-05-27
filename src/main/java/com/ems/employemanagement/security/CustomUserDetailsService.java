package com.ems.employemanagement.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.booking.com.domain.UserDomain;
import com.booking.com.entity.Role;
import com.booking.com.entity.User;
import com.booking.com.service.UserService;




@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService userservice;
	
	
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDomain user=userservice.getUserByUsername(username);
	System.out.println("user--"+user);
		 
		    if(user != null && user.getIsEnabled()) {
		        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		        return buildUserForAuthentication(user, authorities);
		    } 
		    
		    else {
		        throw new UsernameNotFoundException("username not found");
		    }
		
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
	    Set<GrantedAuthority> roles = new HashSet<>();
	    userRoles.forEach((role) -> {
	        roles.add(new SimpleGrantedAuthority(role.getRole()));
	    });

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	}
	
	private UserDetails buildUserForAuthentication(UserDomain user, List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
	
}
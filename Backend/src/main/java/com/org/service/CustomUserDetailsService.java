package com.org.service;

import com.org.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

        User user = this.userService.getUserByEmailId(emailId);

        return org.springframework.security.core.userdetails.User.withUsername(user.getEmailId()).password(user.getPassword()).authorities(user.getRole()).build();
    }
}

/*@Service
public class CustomUserDetailsService implements UserDetailsService {
	
    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
    	
    	Users user = this.userService.getUserByEmailId(emailId);
    	
        return org.springframework.security.core.userdetails.User.withUsername(user.getUserEmail()).password(user.getUserPassword()).authorities(user.getRoles()).build();
        
    }
    	
}*/

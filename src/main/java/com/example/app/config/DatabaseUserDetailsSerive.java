package com.example.app.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.app.model.User;
import com.example.app.repository.UserRepo;

@Component
public class DatabaseUserDetailsSerive implements UserDetailsService {
	
	@Autowired
	public UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		// logic to access the user from the database and provide to
		User user =   userRepo.findByEmail(email).orElseThrow(() ->  new  UsernameNotFoundException("There is no use with this eamil "+ email));
		
	    return     new  DatabaseUserDetail(user.getEmail(), user.password, Arrays.asList(user.getRoles().split(",")));
		
		
	}

}

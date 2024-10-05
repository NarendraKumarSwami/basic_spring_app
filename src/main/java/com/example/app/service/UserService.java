package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.example.app.dto.LoginDto;
import com.example.app.dto.UserDto;
import com.example.app.model.User;
import com.example.app.repository.UserRepo;

@Service
public class UserService {
	
	
	@Autowired
	public PasswordEncoder encoder;
	
	 
	@Autowired
	public UserRepo userRepo;
	
	public String signupService(UserDto userDto) {
		
		 
		  
		 String encodedPassword =  encoder.encode( userDto.getPassword());
		  
		
	   User user =	userRepo.save(User.builder()
				 .name(userDto.getName())
				 .email(userDto.getEmail())
				 .password(encodedPassword)
				 .roles("ROLE_USER")
				.build()
				);
		
		if(user != null) {
			return "user is saved";
		}else 
			throw new RuntimeException("User is not saved");
		
		 
	}

	public boolean signinService(LoginDto userDto) {
		// TODO Auto-generated method stub
		
	 User user =	userRepo.findByEmail(userDto.getEmail()).orElseThrow(() -> new RuntimeException("There is not use with this emails: "+ userDto.getEmail()));
		
	 
	 // check password
	    
	 boolean result =   encoder.matches(userDto.getPassword(), user.getPassword());
	 
	 
	    
		return result;
	}

}

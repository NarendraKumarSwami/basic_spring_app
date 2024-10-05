package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.LoginDto;
import com.example.app.dto.UserDto;
import com.example.app.jwt.JwtService;
import com.example.app.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	public JwtService jwtService;

	 @Autowired
	 public UserService userService;
	
	 @PostMapping("/signup")
	 public ResponseEntity<String> signupController(@RequestBody UserDto userDto){
		 
		 
		 return new ResponseEntity(userService.signupService(userDto), HttpStatus.CREATED);
	 }
	 
	
	 @PostMapping("/signin")
	 public ResponseEntity<Boolean> signinController(@RequestBody LoginDto userDto){
		   
	  boolean result =	 userService.signinService(userDto);
	  
	  // token 
		 String token =  jwtService.generateToken(userDto.email);
		 
		 
		 return ResponseEntity.ok()
				      .header("Authorization", "Bearer "+ token)
				      .body(result);
	 }
}

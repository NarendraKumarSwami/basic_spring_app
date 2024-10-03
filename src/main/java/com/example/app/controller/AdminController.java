package com.example.app.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@GetMapping("/data")
	public ResponseEntity<String> getData(){
		
		return new ResponseEntity("This is secret data ", HttpStatus.OK);
	}

}

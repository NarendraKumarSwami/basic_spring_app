package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.dto.PersonDto;
import com.example.app.service.PersonService;

@Controller
public class ControllerClass {
	
	
	// dependecy of PersonService
	@Autowired
	public PersonService pService;
	
	
	@RequestMapping(path="/home", method = RequestMethod.GET)
	public String getMessage() {
		return "welcome.html";
		
	}
	
	
	@RequestMapping(path="/user", method = RequestMethod.POST,consumes = {"application/json"})
    public ResponseEntity<String> postUserController(@RequestBody PersonDto  person) {
		
		
		  String result =  pService.addPersonService(person);
		
		return  new ResponseEntity<String>(result, HttpStatus.CREATED);
		
	}

}

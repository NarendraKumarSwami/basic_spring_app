package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.dto.PersonDto;
import com.example.app.dto.UpdatePersonDto;
import com.example.app.exception.PersonException;
import com.example.app.model.Person;
import com.example.app.service.PersonService;

import jakarta.validation.Valid;

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
    public ResponseEntity<String> postUserController(@Valid   @RequestBody PersonDto  person) {
		
		
		  String result =  pService.addPersonService(person);
		
		return  new ResponseEntity<String>(result, HttpStatus.CREATED);
		
	}
	
	
	
	@RequestMapping(path="/update/user", params= {"myValue!=suman"},  method= RequestMethod.PUT, consumes = {"application/json"})
	public ResponseEntity<UpdatePersonDto> upddatePersonName(@RequestBody  UpdatePersonDto updateDto, @RequestParam String myValue) {
		   
		    System.out.println(myValue);
		   // PersonService
		   try {
			     pService.updateNameService(updateDto);
		} catch (PersonException e) {
			// TODO: handle exception
			throw new   RuntimeException(e.getMessage());
		}
		     
		     
		System.out.println(updateDto.toString());
		     
		       
		return new ResponseEntity<UpdatePersonDto>(updateDto, HttpStatus.ACCEPTED);
	}
	
	
	
	@RequestMapping(path="/delete/user", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletPersonConteroller(@RequestParam("personId") Integer id){
		
		
		System.out.println(id);
		
		// person service  --
		// delete person  --
		try {
			
			String result = pService.deletePersonService(id);
			
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		} catch (PersonException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		
	
	}
	
	
	@RequestMapping(path="/users", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPerson(){
		
       
		// 
	 List<Person> list =	pService.getAllPersonService();
		
		return new ResponseEntity<List<Person>>(list, HttpStatus.ACCEPTED);
	}

	
	@RequestMapping(path="/users/range", method = RequestMethod.GET)
	public ResponseEntity<List<Person>>  getAllPersonWithRange(Integer start, Integer end){
		    
		
	  List<Person> persons = pService.getAllPersonRangeService(start, end);
		return ResponseEntity.ok(persons);
	
		
		
	}

	@RequestMapping(path="/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonController(@PathVariable("id") Integer id){
    	

	  
		Person p =	pService.getPerson(id);
		
		return ResponseEntity.ok(p);
	
    	
    	
    }


    @GetMapping("/users/search")
    public ResponseEntity<List<Person>> getPersonsByName(@RequestParam("name") String name){
	 
	
    	
    	// service layer 
    	;
	 
	 return new ResponseEntity(pService.findPersonsByName(name), HttpStatus.OK);
     }
	

}

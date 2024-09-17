package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.PersonDto;
import com.example.app.model.Person;
import com.example.app.repository.PersonRepository;


@Service
public class PersonServiceImp  implements PersonService{

	  
	@Autowired
	public PersonRepository pRepo;
	
	@Override
	public String addPersonService(PersonDto personDto) {
		// TODO Auto-generated method stub
		
		// convert this persondto into the person
		
		
		  Person p = new Person();
		  p.setName(personDto.getName());
		  p.setGender(personDto.getGender());
		  p.setAge(personDto.getAge());
		  
		  
		// get the repository 
		 
		
		// save the person using the method from PersonRepository
		Person p1 = pRepo.save(p);
		  
		
		if(p1 != null) {
			return "Person is saved in the database";
		}else {
			return "Person not saved in the database";
		}
		
//		return the result
		
	}

	
	
}

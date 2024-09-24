package com.example.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.PersonDto;
import com.example.app.dto.UpdatePersonDto;
import com.example.app.exception.PersonException;
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

	
	
	
	
	@Override
	public UpdatePersonDto updateNameService(UpdatePersonDto updateDto) throws PersonException {
		// TODO Auto-generated method stub
		
		
		
		// find out the person with the id
		// query the data and get the person based on pass id
		
	    Optional<Person>    opt	  =	pRepo.findById(updateDto.getPersonId());
	    
	    
	    
	      if(opt.isPresent()) {
	    	// update the name in that person object
	    	  Person p =  opt.get();
	    	  
	    	  p.setName(updateDto.getUpdatedName());
	    	  
	    	  
	    	  
	    	  // save tat person back again in database 
	    	  
	    	 Person p1 =  pRepo.save(p);
	    	 
	    	 
	    	 if(p1 != null) {
	    		  return updateDto;
	    	 }else {
	    		 throw new PersonException("Error is occured while updating");
	    	 }
	    	  
	    	  
	      }else
	    	  throw new PersonException("Person with id : "+updateDto.getPersonId()+" don't exits");
		
	

	}





	@Override
	public String deletePersonService(Integer id) throws PersonException {
		// TODO Auto-generated method stub
		
		// find the person with the id
		
	  Optional<Person> opt=	pRepo.findById(id);
	  
	  if(opt.isPresent()) {
	    	// update the name in that person object
	    	  Person p =  opt.get();
	    	  
	    	 
	    	  
	    	  pRepo.delete(p);
	    	  
	    	  
	    	  if(p != null) {
	    		  
	    		  return "person is deleted of id :" +id;
	    	  }else
	    		  throw new PersonException("Error Occured while deleting the person");
	    	  
	    	 
	  
	    	  
	    	  
	      }else
	    	  throw new PersonException("Person with id : "+ id +" don't exits");
	}





	@Override
	public List<Person> getAllPersonService() {
		// TODO Auto-generated method stub
		
		// list of person 
		// person repository
		
		 List<Person>  p =  (List<Person >) pRepo.findAll();
		
		
		return p;
	}





	@Override
	public Person getPerson(Integer id) throws PersonException {
		// TODO Auto-generated method stub
		
		
		 // person repository
		
	  return 	pRepo.findById(id).orElseThrow(() ->  new PersonException("Person with id : "+ id +" don't exits"));
		
		
		
	}





	
	
	
	
	@Override
	public List<Person> getAllPersonRangeService(Integer start, Integer end) throws PersonException {
		// TODO Auto-generated method stub
		
		
	   Optional<List<Person>> opt =   pRepo.findwithRange(start, end);
	 
	    
	    if(opt.isPresent() && opt.get().size() != 0) {
	    
		return  opt.get();
				
	    }else 
	    	throw new PersonException("there is no person in this range"+start + " " + end);

		 
	  
		
	}





	@Override
	public List<Person> findPersonsByName(String name) {
		// TODO Auto-generated method stub
		
		
		
		// 
		
		
		return pRepo.findPersonsByName(name).get();
	}
	
	
	

	
	
}

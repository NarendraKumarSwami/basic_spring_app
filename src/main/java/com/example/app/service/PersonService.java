package com.example.app.service;

import java.util.List;

import com.example.app.dto.PersonDto;
import com.example.app.dto.UpdatePersonDto;
import com.example.app.exception.PersonException;
import com.example.app.model.Person;

public interface PersonService {
	
	
	public String addPersonService(PersonDto personDto);
	
	public UpdatePersonDto updateNameService(UpdatePersonDto updateDto) throws PersonException   ;
	
	
	public String deletePersonService(Integer id) throws PersonException;
	
	
	public List<Person>  getAllPersonService() ;
	
	
	public List<Person> getAllPersonRangeService(Integer start, Integer end) throws PersonException;
	
	
	public Person getPerson(Integer id) throws PersonException;

	public List<Person> findPersonsByName(String name);
	
	
	
	
	

}

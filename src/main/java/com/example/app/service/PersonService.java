package com.example.app.service;

import com.example.app.dto.PersonDto;
import com.example.app.dto.UpdatePersonDto;
import com.example.app.exception.PersonException;

public interface PersonService {
	
	
	public String addPersonService(PersonDto personDto);
	
	public UpdatePersonDto updateNameService(UpdatePersonDto updateDto) throws PersonException   ;
	
	
	public String deletePersonService(Integer id) throws PersonException;
	
	
	

}

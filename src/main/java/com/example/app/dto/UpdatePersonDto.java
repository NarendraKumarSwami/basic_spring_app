package com.example.app.dto;

import org.springframework.stereotype.Component;

@Component
public class UpdatePersonDto {

	
	  public Integer personId;
	  
	  
	  public String  updatedName;


	public Integer getPersonId() {
		return personId;
	}


	public void setPersonId(Integer personId) {
		this.personId = personId;
	}


	public String getUpdatedName() {
		return updatedName;
	}


	public void setUpdatedName(String updatedName) {
		this.updatedName = updatedName;
	}


	@Override
	public String toString() {
		return "UpdatePersonDto [personId=" + personId + ", updatedName=" + updatedName + "]";
	}
	  
	  
	  
	  
	  
	
	
}

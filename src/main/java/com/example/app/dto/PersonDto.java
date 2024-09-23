package com.example.app.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class PersonDto {
	
	  
	 @NotBlank(message= "{name.blank}")
	 @NotNull(message="{name.null}")
	 @NotEmpty(message="{name.empty}")
	 private String name;
	 
	 
	 @Min(value = 18, message = "age should be greater than 18")
	 private Integer age;
	 
	 
	 private  String gender;
	 
	 
	 
	 public PersonDto() {
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "PersonDto [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	 
	 
	

}

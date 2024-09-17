package com.example.app.dto;

import org.springframework.stereotype.Component;

@Component
public class PersonDto {
	
	
	 private String name;
	 
	 
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

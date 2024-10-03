package com.example.app.model;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
     
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  public Integer pId;
	  
	  
	  
	  public String name;
	  
	  
	  public Integer age;
	  
	  public String gender;
	  
	 
	  
	  
	  
	  public Person() {
		// TODO Auto-generated constructor stub
	}



	public Integer getpId() {
		return pId;
	}



	public void setpId(Integer pId) {
		this.pId = pId;
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
	  
	  
	  
	  
	  
}

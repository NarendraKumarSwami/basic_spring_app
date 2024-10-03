package com.example.app.model;

import org.hibernate.internal.build.AllowNonPortable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	public Integer id;
	
	
	public String name;
	
	@Column(unique = true)
	public String email;
	
	public String password;
	
	public String roles;

}

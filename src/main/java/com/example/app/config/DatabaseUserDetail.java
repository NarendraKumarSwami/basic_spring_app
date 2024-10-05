package com.example.app.config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUserDetail implements UserDetails {
	
	 
	    public String email;
	    
	    public String password;
	    
	    
	    public List<GrantedAuthority> authorities;
	    
	    
	    public DatabaseUserDetail() {
			// TODO Auto-generated constructor stub
		}
	    
	   
	  public DatabaseUserDetail(String email, String password, List<String> roles) {
		  
		  this.email = email;
		  this.password = password;
		  this.authorities  = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		  
	  }
	    
	    

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

}

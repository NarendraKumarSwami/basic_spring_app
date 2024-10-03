package com.example.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfig {
	
	
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
	
		
		 return    http.csrf(csrf -> csrf.disable())
			     .authorizeHttpRequests(authRequest -> {
			    	 authRequest.requestMatchers("/home", "/signup", "/signin").permitAll();
			    	 authRequest.requestMatchers("/about").authenticated();
			    	 authRequest.requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN");
			     }).formLogin(Customizer.withDefaults()).build();
			     
			     
			     
	}
	
	
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	

}

package com.example.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.app.filter.JwtFilter;

@Configuration
@EnableWebSecurity
public class SpringConfig {
	
	@Autowired 
	public DatabaseUserDetailsSerive dbaService;
	
	
	@Autowired 
	public JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
	
		
		 return    http.csrf(csrf -> csrf.disable())
			     .authorizeHttpRequests(authRequest -> {
			    	 authRequest.requestMatchers("/home", "/signup", "/signin").permitAll();
			    	 authRequest.requestMatchers("/about", "/user", "/users").authenticated();
			    	 authRequest.requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN");
			     }).sessionManagement(session -> session.disable())
			     .authenticationProvider(authProvider())
			     .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			     .build();
			     
			     
			     
	}
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		
		daoProvider.setUserDetailsService(dbaService);
		daoProvider.setPasswordEncoder(encoder());
		return daoProvider;
		
	}
	
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean 
	public AuthenticationManager authencticationConfig(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
	}
	
	

}

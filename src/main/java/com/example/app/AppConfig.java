package com.example.app;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfig {
        
	
	
	
	 @Bean
	 public LocalValidatorFactoryBean getValidatorbean(MessageSource ms) {
		 
		        
		                 
		       LocalValidatorFactoryBean ls =       new   LocalValidatorFactoryBean();
		        ls.setValidationMessageSource(ms);
		 return ls;
	 }
}

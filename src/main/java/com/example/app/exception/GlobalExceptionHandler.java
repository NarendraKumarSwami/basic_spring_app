package com.example.app.exception;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.PseudoColumnUsage;
import java.time.LocalDateTime;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(PersonException.class)
	public ResponseEntity<ExceptionDetails> personEception(PersonException pe){
	
		
		 ExceptionDetails    personError =        new ExceptionDetails(pe.getMessage(), HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(), null);
		
		return new ResponseEntity(personError, HttpStatus.NOT_ACCEPTABLE);
	}
//	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDetails> personEception(MethodArgumentNotValidException pe){
	
		
	
		
		 ExceptionDetails    personError =        new ExceptionDetails(pe.getAllErrors().get(0).toString(), HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(), null);
		
		return new ResponseEntity(personError, HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> personEception(HttpServletResponse res, Exception pe){
	
		
		 ExceptionDetails    personError =        new ExceptionDetails(pe.getMessage(), HttpStatusCode.valueOf(res.getStatus()), LocalDateTime.now(), null);
		
		return new ResponseEntity(personError, HttpStatusCode.valueOf(res.getStatus()));
	}
//	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDetails> nohandlerException(NoHandlerFoundException ne){
		
		  
		
		 ExceptionDetails    noHandlerError =        new ExceptionDetails(ne.getMessage(), ne.getStatusCode(), LocalDateTime.now(), null);
			
			return new ResponseEntity(noHandlerError, ne.getStatusCode());
	}
	

}

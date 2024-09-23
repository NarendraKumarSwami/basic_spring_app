package com.example.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class ExceptionDetails {
	
	   public String message;
	   
	   
	   public HttpStatusCode code;
	   
	   
	   public LocalDateTime timestamp;
	   
	   
	   public String path;
	   
	   
	   public ExceptionDetails() {
		// TODO Auto-generated constructor stub
	}




	public ExceptionDetails(String message, HttpStatusCode code, LocalDateTime timestamp, String path) {
		super();
		this.message = message;
		this.code = code;
		this.timestamp = timestamp;
		this.path = path;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public HttpStatusCode getCode() {
		return code;
	}




	public void setCode(HttpStatusCode code) {
		this.code = code;
	}




	public LocalDateTime getTimestamp() {
		return timestamp;
	}




	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}




	public String getPath() {
		return path;
	}




	public void setPath(String path) {
		this.path = path;
	}
	   
	   
	   
	   

}

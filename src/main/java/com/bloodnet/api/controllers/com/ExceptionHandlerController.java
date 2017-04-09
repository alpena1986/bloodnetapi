package com.bloodnet.api.controllers.com;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bloodnet.api.com.exception.BadRequestException;
import com.bloodnet.api.com.exception.UserAlreadyExistsException;
import com.bloodnet.api.com.exception.UserNotFoundException;
import com.bloodnet.lib.Error;

@RestControllerAdvice
public class ExceptionHandlerController{

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Error badRequest(BadRequestException ex){
		return new Error(1, "bad request");
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public Error userAlreadyExists(UserAlreadyExistsException ex){
		return new Error(800, "user already exists");
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Error> userNotFound(UserNotFoundException ex){
		Error error = new Error(801, "user not found");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<Error> entity = new ResponseEntity<Error>(error, headers, HttpStatus.NOT_FOUND );
		return entity ;
	}
}
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
import com.bloodnet.lib.RestResponseBody;

@RestControllerAdvice
public class ExceptionHandlerController{

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RestResponseBody badRequest(BadRequestException ex){
		return RestResponseBody.BAD_REQUEST;
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public RestResponseBody userAlreadyExists(UserAlreadyExistsException ex){
		RestResponseBody error = new RestResponseBody(
				RestResponseBody.CODE_USER_ALREADY_EXIST, 
				RestResponseBody.NAME_USER_ALREADY_EXIST, 
				"user already exist");
		return error;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<RestResponseBody> userNotFound(UserNotFoundException ex){
		RestResponseBody error = new RestResponseBody(
				RestResponseBody.CODE_USER_NOT_FOUND, 
				RestResponseBody.NAME_USER_NOT_FOUND, 
				"user not found");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<RestResponseBody> entity = new ResponseEntity<RestResponseBody>(error, headers, HttpStatus.NOT_FOUND );
		return entity ;
	}
}
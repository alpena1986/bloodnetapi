package com.bloodnet.api.controllers.com;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bloodnet.api.com.exception.UserAlreadyExistsException;
import com.bloodnet.lib.Error;

@RestControllerAdvice
public class ExceptionHandlerController{

	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public Error userAlreadyExists(UserAlreadyExistsException ex){
		return new Error(1, "user already exists.");
	}
	
}
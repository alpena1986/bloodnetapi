package com.bloodnet.api.com.exception;

public class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 551500574728741002L;

	public UserAlreadyExistsException(String userId){
		this.userId = userId;
	}
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}

package com.bloodnet.api.com.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5436995444915132979L;

	public UserNotFoundException(String userId){
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

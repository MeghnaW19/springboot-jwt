package com.stackroute.exception;

public class UserAlreadyExistException extends Exception{

	String message;

	public UserAlreadyExistException(String message) {
		super(message);
		this.message = message;
	}

	public UserAlreadyExistException() {
	}


}

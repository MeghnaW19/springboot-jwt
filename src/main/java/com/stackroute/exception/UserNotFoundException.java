package com.stackroute.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	String message;

	public UserNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public UserNotFoundException() {
	}

}

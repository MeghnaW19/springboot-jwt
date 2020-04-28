package com.stackroute.service;

import com.stackroute.exception.UserAlreadyExistException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.domain.User;

public interface UserService {

	public User saveUser(User user)throws UserAlreadyExistException;
	public User findByIdAndPassword(String id, String password) throws UserNotFoundException;
}

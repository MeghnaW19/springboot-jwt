package com.stackroute.config;

import java.util.Map;

import com.stackroute.domain.User;

public interface JWTTokenGenerator {
	public Map<String, String> generateToken(User user);
}

package com.stackroute.repo;

import com.stackroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByIdAndPassword(String id, String password);
	
}

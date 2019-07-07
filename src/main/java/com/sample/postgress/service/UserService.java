package com.sample.postgress.service;

import java.util.List;
import com.sample.postgress.entity.User;

public interface UserService {
	
	List<User> findAll();

	void insertUser(User user);
	
	void updateUser(User user);

	void executeUpdateUser(User user);

	void deleteUser(User user);
	
}

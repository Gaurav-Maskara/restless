package com.sample.postgress.dao;

import java.util.List;
import com.sample.postgress.entity.User;

public interface UserDao {

	List<User> findAll();

	void insertUser(User user);

	void updateUser(User user);

	void executeUpdateUser(User user);

	public void deleteUser(User user);
}

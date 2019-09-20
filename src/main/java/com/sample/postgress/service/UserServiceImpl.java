package com.sample.postgress.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.sample.postgress.dao.UserDao;
import com.sample.postgress.entity.User;

@Component
public class UserServiceImpl implements UserService{
	
	@Resource 
	UserDao UserDao;
	
	@Override
	public List<User> findAll() {
		return UserDao.findAll();
	}
	
	@Override
	public void insertUser(User user) {
		UserDao.insertUser(user);
	}
	
	@Override
	public void updateUser(User user) {
		UserDao.updateUser(user);
	}
	
	@Override
	public void executeUpdateUser(User user) {
		UserDao.executeUpdateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		UserDao.deleteUser(user);
	}
}

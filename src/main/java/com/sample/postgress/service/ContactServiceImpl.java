package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.ContactDao;
import com.sample.postgress.entity.Contact;
@Component
public class ContactServiceImpl implements ContactService{
	@Resource 
	ContactDao ContactDao;
	
	@Override
	public List<Contact> findAll() {
		return ContactDao.findAll();
	}
	@Override
	public void insertContact(Contact emp) {
		ContactDao.insertContact(emp);
		
	}
	@Override
	public void updateContact(Contact emp) {
		ContactDao.updateContact(emp);
		
	}
	@Override
	public void executeUpdateContact(Contact emp) {
		ContactDao.executeUpdateContact(emp);
		
	}

	@Override
	public void deleteContact(Contact emp) {
		ContactDao.deleteContact(emp);
		
	}
}

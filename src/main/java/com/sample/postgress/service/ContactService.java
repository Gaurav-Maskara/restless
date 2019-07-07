package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Contact;

public interface ContactService {
	List<Contact> findAll();

	void insertContact(Contact contact);

	void updateContact(Contact contact);

	void executeUpdateContact(Contact contact);

	void deleteContact(Contact contact);
	
}

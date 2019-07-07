package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Contact;

public interface ContactDao {

	List<Contact> findAll();

	void insertContact(Contact contact);

	void updateContact(Contact contact);

	void executeUpdateContact(Contact contact);

	public void deleteContact(Contact contact);
}

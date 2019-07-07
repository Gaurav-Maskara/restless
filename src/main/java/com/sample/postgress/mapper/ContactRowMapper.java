package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int arg1) throws SQLException {
		Contact contact = new Contact();
		contact.setName(rs.getString("name"));
		contact.setEmail(rs.getString("email"));
		contact.setMessage(rs.getString("message"));
 
        return contact;
	}


}

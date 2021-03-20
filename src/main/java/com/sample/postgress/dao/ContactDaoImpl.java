package com.sample.postgress.dao;

import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.Contact;
import com.sample.postgress.mapper.ContactRowMapper;


@Repository
public class ContactDaoImpl implements ContactDao{
	
	public ContactDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Contact> findAll() {
	   return template.query("select * from contact", new ContactRowMapper());
	}
	
	@Override
	public void insertContact(Contact contact) {
		  String sql = "insert into contact(name, email ,message) values(:name,:email,:message)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("name", contact.getName())
					.addValue("email", contact.getEmail())
					.addValue("message", contact.getMessage());
	        
	        template.update(sql,param, holder);
	}
	
	@Override
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void executeUpdateContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}
	
}

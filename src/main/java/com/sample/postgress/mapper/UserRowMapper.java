package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		
		user.setUserName(rs.getString("username"));
		user.setUserAddress(rs.getString("useraddress"));
		user.setUserEmail(rs.getString("useremail"));
		user.setUserPassword("***********");
 
        return user;
	}


}

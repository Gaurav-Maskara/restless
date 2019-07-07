package com.sample.postgress.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.User;
import com.sample.postgress.mapper.UserRowMapper;
@Repository
public class UserDaoImpl implements UserDao{
	
	public UserDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<User> findAll() {
	   return template.query("select * from users", new UserRowMapper());
	}
	@Override
	public void insertUser(User user) {
		  String sql = "insert into users(username, useraddress ,useremail, userpassword) values(:username,:useraddress,:useremail,:userpassword)";
		 
		 
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("username", user.getUserName())
					.addValue("useraddress", user.getUserAddress())
					.addValue("useremail", user.getUserEmail())
					.addValue("userpassword", user.getUserPassword());
	        
	        
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateUser(User user) {
		 final String sql = "update users set useraddress=:useraddress, useremail=:useremail, userpassword=:userpassword where username=:username";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("username", user.getUserName())
					.addValue("useraddress", user.getUserAddress())
					.addValue("useremail", user.getUserEmail())
					.addValue("userpassword", user.getUserPassword());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void executeUpdateUser(User user) {
		 final String sql = "update users set useraddress=:useraddress, useremail=:useremail, userpassword=:userpassword where username=:username";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("username", user.getUserName());
		 map.put("useraddress", user.getUserAddress());
		 map.put("useremail", user.getUserEmail());
		 map.put("userpassword", user.getUserPassword());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void deleteUser(User user) {
		 final String sql = "delete from users where username=:username";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("username", user.getUserName());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
}

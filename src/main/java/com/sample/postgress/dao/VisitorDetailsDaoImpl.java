package com.sample.postgress.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.Contact;
import com.sample.postgress.entity.VisitorDetails;
import com.sample.postgress.mapper.ContactRowMapper;
import com.sample.postgress.mapper.VisitorDetailsRowMapper;


@Repository
public class VisitorDetailsDaoImpl implements VisitorDetailsDao{
	
	public VisitorDetailsDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  
	
	@Override
	public List<VisitorDetails> findAll() {
	   return template.query("select * from VisitorDetails", new VisitorDetailsRowMapper());
	}
	
	@Override
	public void insertVisitorDetails(VisitorDetails visitorDetails) {
		  String sql = "insert into VisitorDetails(ip, city ,latitude, longitude) values(:ip,:city,:latitude, :longitude)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("ip", visitorDetails.getIp())
					.addValue("city", visitorDetails.getCity())
					.addValue("latitude", visitorDetails.getLatitude())
					.addValue("longitude", visitorDetails.getLongitude());
	        
	        template.update(sql,param, holder);
	}
	
}

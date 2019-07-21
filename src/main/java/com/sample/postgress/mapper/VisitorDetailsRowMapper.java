package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Contact;
import com.sample.postgress.entity.VisitorDetails;

public class VisitorDetailsRowMapper implements RowMapper<VisitorDetails> {

	@Override
	public VisitorDetails mapRow(ResultSet rs, int arg1) throws SQLException {
		VisitorDetails visitorDetails = new VisitorDetails();
		
		visitorDetails.setIp(rs.getString("ip"));
		visitorDetails.setCity(rs.getString("city"));
		visitorDetails.setLatitude(rs.getString("latitude"));
		visitorDetails.setLongitude(rs.getString("longitude"));
 
        return visitorDetails;
	}


}

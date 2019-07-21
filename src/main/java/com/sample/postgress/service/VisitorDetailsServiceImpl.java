package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.sample.postgress.dao.VisitorDetailsDao;
import com.sample.postgress.entity.Contact;
import com.sample.postgress.entity.VisitorDetails;

@Component
public class VisitorDetailsServiceImpl implements VisitorDetailsService{
	@Resource 
	VisitorDetailsDao visitorDetailsDao;
	
	@Override
	public List<VisitorDetails> findAll() {
		return visitorDetailsDao.findAll();
	}
	
	@Override
	public void insertVisitorDetails(VisitorDetails visitorDetails) {
		visitorDetailsDao.insertVisitorDetails(visitorDetails);
	}
}

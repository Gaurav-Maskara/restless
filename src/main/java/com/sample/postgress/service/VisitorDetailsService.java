package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Contact;
import com.sample.postgress.entity.VisitorDetails;

public interface VisitorDetailsService {
	
	List<VisitorDetails> findAll();
	
	void insertVisitorDetails(VisitorDetails visitorDetails);
}

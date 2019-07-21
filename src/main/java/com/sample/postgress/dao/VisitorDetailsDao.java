package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.VisitorDetails;

public interface VisitorDetailsDao {
	
	List<VisitorDetails> findAll();

	void insertVisitorDetails(VisitorDetails visitorDetails);

}

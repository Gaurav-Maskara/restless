package com.sample.postgress.entity;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

public class Employee extends ResourceSupport implements Serializable {
	
	private static final long serialVersionUID = 1L;

	String employeeId;
	String employeeName;
	String employeeEmail;
	String employeeAddress;
	
	
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	
}

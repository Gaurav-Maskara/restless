package com.sample.postgress.entity;

public class User {
	
	private String userName;
	private String userAddress;
	private String userEmail;
	private String userPassword;

	public User() {
		super();
	}

	public User(String userName, String userAddress, String userEmail, String userPassword) {
		super();
		this.userName = userName;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}

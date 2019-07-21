package com.sample.postgress.entity;

public class VisitorDetails {
	
	private String ip;
	private String city;
	private String latitude;
	private String longitude;
	
	public VisitorDetails() {
		super();
	}

	public VisitorDetails(String ip, String city, String latitude, String longitude) {
		super();
		this.ip = ip;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	

}

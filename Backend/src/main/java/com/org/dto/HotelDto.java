package com.org.dto;


import com.org.model.Facility;

import java.util.List;

public class HotelDto {
private int id;
	
	private String name;
	
	private String description;
	
	private String location;   // city from Location Class  
	
	private String street;
	
	private String pincode;
	
	private String emailId;    
	
	private double pricePerDay;   // price per day per room
	
	private int totalRoom; 
	
	private List<Facility> facility;
	
	/*
	 * private String image1;
	 * 
	 * private String image2;
	 * 
	 * private String image3;
	 */
	
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getTotalRoom() {
		return totalRoom;
	}

	public void setTotalRoom(int totalRoom) {
		this.totalRoom = totalRoom;
	}

	public List<Facility> getFacility() {
		return facility;
	}

	public void setFacility(List<Facility> facility) {
		this.facility = facility;
	}

	/*
	 * public String getImage1() { return image1; }
	 * 
	 * public void setImage1(String image1) { this.image1 = image1; }
	 * 
	 * public String getImage2() { return image2; }
	 * 
	 * public void setImage2(String image2) { this.image2 = image2; }
	 * 
	 * public String getImage3() { return image3; }
	 * 
	 * public void setImage3(String image3) { this.image3 = image3; }
	 */

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}

package com.org.dto;



import com.org.model.Hotel;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;


public class HotelAddRequest {
	private int id;

	private String name;

	private String description;
	
	private int locationId;

	private String street;

	private String pincode;

	private String emailId;

	private double pricePerDay; // price per day per room

	private int totalRoom;
	
	private int userId;
	
	/*
	 * private MultipartFile image1;
	 * 
	 * private MultipartFile image2;
	 * 
	 * private MultipartFile image3;
	 */
	
	
	
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



	public int getLocationId() {
		return locationId;
	}



	public void setLocationId(int locationId) {
		this.locationId = locationId;
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



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	/*
	 * public MultipartFile getImage1() { return image1; }
	 * 
	 * 
	 * 
	 * public void setImage1(MultipartFile image1) { this.image1 = image1; }
	 * 
	 * 
	 * 
	 * public MultipartFile getImage2() { return image2; }
	 * 
	 * 
	 * 
	 * public void setImage2(MultipartFile image2) { this.image2 = image2; }
	 * 
	 * 
	 * 
	 * public MultipartFile getImage3() { return image3; }
	 * 
	 * 
	 * 
	 * public void setImage3(MultipartFile image3) { this.image3 = image3; }
	 * 
	 */

	public static Hotel toEntity(HotelAddRequest hotelAddRequest) {
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(hotelAddRequest, hotel, "locationId","image1","image2","image3");
		return hotel;
	}

}

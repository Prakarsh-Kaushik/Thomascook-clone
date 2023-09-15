package com.org.dto;

import com.org.model.Hotel;

import java.util.List;




public class HotelAddResponse extends CommanApiResponse {
	List<Hotel> hotels;

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
}

package com.org.dto;


import com.org.model.Hotel;

public class HotelResponseDto extends CommanApiResponse{

	private Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}

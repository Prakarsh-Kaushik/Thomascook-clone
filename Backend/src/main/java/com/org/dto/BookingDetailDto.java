package com.org.dto;

import java.util.List;


public class BookingDetailDto extends CommanApiResponse{
	List<BookingDto> bookings;

	public List<BookingDto> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDto> bookings) {
		this.bookings = bookings;
	}

}

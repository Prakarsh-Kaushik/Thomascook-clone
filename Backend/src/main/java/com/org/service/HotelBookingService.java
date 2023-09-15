package com.org.service;


import com.org.dao.HotelBookingDao;
import com.org.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelBookingService {
	@Autowired
	private HotelBookingDao bookingDao;
	
	public HotelBooking bookHotel(HotelBooking booking) {
		return bookingDao.save(booking);
	}

	public List<HotelBooking> getAllBookings() {
		return bookingDao.findAll();
	}
	
	public List<HotelBooking> getMyBookings(int userId) {
		return bookingDao.findByUserId(userId);
	}
	
	public List<HotelBooking> getMyHotelBookings(int hotelId) {
		return bookingDao.findByHotelId(hotelId);
	}
	
	public HotelBooking getBookingById(int bookingId) {
		return bookingDao.findById(bookingId).get();
	}
}

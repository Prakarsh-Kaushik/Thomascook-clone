package com.org.service;

import java.util.List;

import com.org.dao.HotelDao;
import com.org.model.Hotel;
import com.org.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HotelService {

	@Autowired
	private HotelDao hotelDao;

	public Hotel addHotel(Hotel hotel) {
		return hotelDao.save(hotel);
	}
	
	public List<Hotel> fetchAllHotels() {
		return hotelDao.findAll();
	}
	
	public List<Hotel> fetchHotelsByLocation(Location locationId) {
		return hotelDao.findByLocation(locationId);
	}
	
	public Hotel fetchHotel(int hotelId) {
		return hotelDao.findById(hotelId).get();
	}

}

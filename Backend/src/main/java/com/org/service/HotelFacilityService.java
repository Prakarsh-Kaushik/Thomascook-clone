package com.org.service;

import java.util.List;

import com.org.dao.HotelFacilityDao;
import com.org.model.HotelFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelFacilityService {
	@Autowired
	private HotelFacilityDao hotelFacilityDao;
	
	public List<HotelFacility> getHotelFacilitiesByHotelId(int hotelId) {
		return this.hotelFacilityDao.findByHotelId(hotelId);
	}
	
	public HotelFacility addFacility(HotelFacility hotelFacility) {
	    return this.hotelFacilityDao.save(hotelFacility);
	}
}

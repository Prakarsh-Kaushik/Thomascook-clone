package com.org.dao;

import java.util.List;

import com.org.model.HotelFacility;
import org.springframework.data.jpa.repository.JpaRepository;



public interface HotelFacilityDao extends JpaRepository<HotelFacility, Integer>{
	List<HotelFacility> findByHotelId(int hotelId);
}

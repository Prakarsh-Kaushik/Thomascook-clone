package com.org.dao;


import com.org.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelBookingDao extends JpaRepository<HotelBooking, Integer> {

	List<HotelBooking> findByUserId(int userId);
	List<HotelBooking> findByHotelId(int hotelId);
}

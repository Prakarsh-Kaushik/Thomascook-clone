package com.org.dao;

import java.util.List;

import com.org.model.Hotel;
import com.org.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer> {
	
	List<Hotel> findByLocation(Location locationId);
	
}

package com.org.service;

import java.util.List;

import com.org.dao.LocationDao;
import com.org.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class LocationService {
	@Autowired
	private LocationDao locationDao;
	
	public Location addLocation(@RequestBody Location location) {
		return locationDao.save(location);
	}
	
	public List<Location> fetchAllLocations() {
		return locationDao.findAll();
	}
	
	public Location getLocationById(int id) {
		return locationDao.findById(id).get();
	}

}

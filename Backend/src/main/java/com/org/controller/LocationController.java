package com.org.controller;

import java.util.List;

import com.org.dto.CommanApiResponse;
import com.org.dto.LocationFetchResponse;
import com.org.model.Location;
import com.org.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.org.utility.Constants.ResponseCode;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/location/")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {
	Logger LOG = LoggerFactory.getLogger(LocationController.class);

	@Autowired
	private LocationService locationService;

	@PostMapping("add")
	public ResponseEntity<?> register(@RequestBody Location location) {
		LOG.info("Recieved request for Add Location");

		CommanApiResponse response = new CommanApiResponse();

		Location addedLocation = locationService.addLocation(location);

		if (addedLocation != null) {
			response.setResponseCode(ResponseCode.SUCCESS.value());
			response.setResponseMessage("Location Added Successfully");
			return new ResponseEntity(response, HttpStatus.OK);
		}

		else {
			response.setResponseCode(ResponseCode.FAILED.value());
			response.setResponseMessage("Failed to add Location");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("fetch")

	public ResponseEntity<?> fetchAllLocations() {
		LOG.info("Recieved request for Fetch Location");

		LocationFetchResponse locationFetchResponse = new LocationFetchResponse();

		List<Location> locations = locationService.fetchAllLocations();

		try {
			locationFetchResponse.setLocations(locations);
			locationFetchResponse.setResponseCode(ResponseCode.SUCCESS.value());
			locationFetchResponse.setResponseMessage("Location Fetched Successfully");
			
			return new ResponseEntity(locationFetchResponse, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Exception Caught");
			locationFetchResponse.setResponseCode(ResponseCode.FAILED.value());
			locationFetchResponse.setResponseMessage("Failed to Fetch Location");
			return new ResponseEntity(locationFetchResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}

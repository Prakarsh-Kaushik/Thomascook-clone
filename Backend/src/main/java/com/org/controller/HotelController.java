package com.org.controller;

import java.util.ArrayList;
import java.util.List;

import com.org.dto.CommanApiResponse;
import com.org.dto.HotelAddRequest;
import com.org.dto.HotelAddResponse;
import com.org.dto.HotelResponseDto;
import com.org.exceptions.HotelNotFoundException;
import com.org.model.Hotel;
import com.org.model.Location;
import com.org.model.User;
import com.org.service.HotelService;
import com.org.service.LocationService;
import com.org.service.UserService;
import com.org.utility.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.org.utility.Constants.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/hotel/")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {
	Logger LOG = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelService hotelService;

	@Autowired
	private LocationService locationService;

	
	@Autowired
	private UserService userService;

	@PostMapping("add")

	public ResponseEntity<?> register(HotelAddRequest hotelAddRequest) {
		LOG.info("Recieved request for Add Hotel");

		CommanApiResponse response = new CommanApiResponse();

		if (hotelAddRequest == null) {
			throw new HotelNotFoundException();
		}

		if (hotelAddRequest.getLocationId() == 0) {
			response.setResponseCode(Constants.ResponseCode.FAILED.value());
			response.setResponseMessage("Hotel Location is not selected");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}

		if (hotelAddRequest.getUserId() == 0) {
			response.setResponseCode(Constants.ResponseCode.FAILED.value());
			response.setResponseMessage("Hotel Admin is not selected");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}

		Hotel hotel = HotelAddRequest.toEntity(hotelAddRequest);
		Location location = locationService.getLocationById(hotelAddRequest.getLocationId());
		hotel.setLocation(location);

		/*
		 * String image1 = storageService.store(hotelAddRequest.getImage1()); String
		 * image2 = storageService.store(hotelAddRequest.getImage2()); String image3 =
		 * storageService.store(hotelAddRequest.getImage3()); hotel.setImage1(image1);
		 * hotel.setImage2(image2); hotel.setImage3(image3);
		 */
		Hotel addedHotel = hotelService.addHotel(hotel);

		if (addedHotel != null) {

			User hotelAdmin = userService.getUserById(hotelAddRequest.getUserId());
			hotelAdmin.setHotelId(addedHotel.getId());
			this.userService.updateUser(hotelAdmin);

			response.setResponseCode(Constants.ResponseCode.SUCCESS.value());
			response.setResponseMessage("Hotel Added Successfully");
			return new ResponseEntity(response, HttpStatus.OK);
		}

		else {
			response.setResponseCode(Constants.ResponseCode.FAILED.value());
			response.setResponseMessage("Failed to add Hotel");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("id")
	public ResponseEntity<?> fetchHotel(@RequestParam("hotelId") int hotelId) {
		LOG.info("Recieved request for Fetch Hotel using hotel Id");

		HotelResponseDto response = new HotelResponseDto();

		Hotel hotel = hotelService.fetchHotel(hotelId);

		if (hotel == null) {
			throw new HotelNotFoundException();
		}

		try {
			response.setHotel(hotel);
			response.setResponseCode(ResponseCode.SUCCESS.value());
			response.setResponseMessage("Hotel Fetched Successfully");
			return new ResponseEntity(response, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Exception Caught");
			response.setResponseCode(ResponseCode.FAILED.value());
			response.setResponseMessage("Failed to Fetch Hotel");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("fetch")

	public ResponseEntity<?> fetchAllHotels() {
		LOG.info("Recieved request for Fetch Hotels");

		HotelAddResponse hotelAddResponse = new HotelAddResponse();

		List<Hotel> hotels = hotelService.fetchAllHotels();
		try {
			hotelAddResponse.setHotels(hotels);
			hotelAddResponse.setResponseCode(ResponseCode.SUCCESS.value());
			hotelAddResponse.setResponseMessage("Hotels Fetched Successfully");
			return new ResponseEntity(hotelAddResponse, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Exception Caught");
			hotelAddResponse.setResponseCode(ResponseCode.FAILED.value());
			hotelAddResponse.setResponseMessage("Failed to Fetch Hotels");
			return new ResponseEntity(hotelAddResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("location")
	
	public ResponseEntity<?> getProductsByCategories(@RequestParam("locationId") int locationId) {

		System.out.println("request came for getting all hotels by locations");

		HotelAddResponse hotelAddResponse = new HotelAddResponse();

		List<Hotel> hotels = new ArrayList<Hotel>();

		Location location = locationService.getLocationById(locationId);

		hotels = this.hotelService.fetchHotelsByLocation(location);

		try {
			hotelAddResponse.setHotels(hotels);
			hotelAddResponse.setResponseCode(ResponseCode.SUCCESS.value());
			hotelAddResponse.setResponseMessage("Hotels Fetched Successfully");
			return new ResponseEntity(hotelAddResponse, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Exception Caught");
			hotelAddResponse.setResponseCode(ResponseCode.FAILED.value());
			hotelAddResponse.setResponseMessage("Failed to Fetch Hotels");
			return new ResponseEntity(hotelAddResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}

package com.org.controller;


import com.org.dto.BookingDetailDto;
import com.org.dto.BookingDto;
import com.org.dto.CommanApiResponse;
import com.org.dto.UpdateBookingStatusRequestDto;
import com.org.exceptions.BookingNotFoundException;
import com.org.model.Hotel;
import com.org.model.HotelBooking;
import com.org.model.User;
import com.org.service.HotelBookingService;
import com.org.service.HotelService;
import com.org.service.UserService;
import com.org.utility.Constants;
import com.org.utility.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.org.utility.Constants.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/book/hotel")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelBookingController {
	Logger LOG = LoggerFactory.getLogger(HotelBookingController.class);

	@Autowired
	private HotelBookingService bookingService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> register(HotelBooking booking) {
		LOG.info("Recieved request for booking hotel");

		System.out.println(booking);

		CommanApiResponse response = new CommanApiResponse();

		if (booking == null) {
//			response.setResponseCode(ResponseCode.FAILED.value());
//			response.setResponseMessage("Hotel Booking Failed");
//			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
			
			throw new BookingNotFoundException();
		}

		if (booking.getUserId() == 0) {
			response.setResponseCode(Constants.ResponseCode.FAILED.value());
			response.setResponseMessage("User is not not looged in");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}

		if (booking.getHotelId() == 0) {
			response.setResponseCode(ResponseCode.FAILED.value());
			response.setResponseMessage("Hotel not found to Book");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}

		Hotel hotel = hotelService.fetchHotel(booking.getHotelId());

		if (hotel == null) {
			response.setResponseCode(Constants.ResponseCode.FAILED.value());
			response.setResponseMessage("No Hotel present with this Id");
		}

		booking.setStatus(Constants.BookingStatus.PENDING.value());

		booking.setBookingId(Helper.getAlphaNumericId());

		HotelBooking bookedHotel = this.bookingService.bookHotel(booking);

		if (bookedHotel != null) {
			response.setResponseCode(ResponseCode.SUCCESS.value());
			response.setResponseMessage(
					"Hotel Booked Added Successfully, Please Check Approval Status on Booking Option");
			return new ResponseEntity(response, HttpStatus.OK);
		}

		else {
			response.setResponseCode(ResponseCode.FAILED.value());
			response.setResponseMessage("Failed to Book Hotel");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/fetch/all")
	public ResponseEntity<?> fetchAllHotelBooking() {
		LOG.info("Recieved request for fetch all booking");

		BookingDetailDto response = new BookingDetailDto();

		List<BookingDto> bookings = new ArrayList<>();

		List<HotelBooking> allBookings = this.bookingService.getAllBookings();

		for (HotelBooking booking : allBookings) {

			BookingDto dto = new BookingDto();

			dto.setBookingId(booking.getBookingId());
			dto.setCheckIn(booking.getCheckIn());
			dto.setCheckOut(booking.getCheckOut());

			User customer = this.userService.getUserById(booking.getUserId());
			dto.setCustomerName(customer.getFirstName() + " " + customer.getLastName());

			Hotel hotel = this.hotelService.fetchHotel(booking.getHotelId());
			User hotelUser = this.userService.getUserById(hotel.getUserId());
			dto.setHotelEmail(hotelUser.getEmailId());
			dto.setHotelContact(hotelUser.getContact());
			dto.setHotelId(hotel.getId());
			dto.setStatus(booking.getStatus());
			dto.setTotalDay(booking.getTotalDay());
			dto.setTotalRoom(booking.getTotalRoom());
			dto.setUserId(customer.getId());
			dto.setHotelName(hotel.getName());
			/* dto.setHotelImage(hotel.getImage1()); */
			dto.setCustomerContact(customer.getContact());
			dto.setTotalAmount(String.valueOf(hotel.getPricePerDay() * booking.getTotalRoom() * booking.getTotalDay()));
			dto.setId(booking.getId());

			bookings.add(dto);
		}

		response.setBookings(bookings);
		response.setResponseCode(ResponseCode.SUCCESS.value());
		response.setResponseMessage("Booking Fetched Successfully");
		return new ResponseEntity(response, HttpStatus.OK);

	}

	@GetMapping("/fetch")
	public ResponseEntity<?> fetchMyBooking(@RequestParam("userId") int userId) {
		LOG.info("Recieved request for fetch all booking");

		BookingDetailDto response = new BookingDetailDto();

		List<BookingDto> bookings = new ArrayList<>();

		List<HotelBooking> allBookings = this.bookingService.getMyBookings(userId);

		for (HotelBooking booking : allBookings) {

			BookingDto dto = new BookingDto();

			dto.setBookingId(booking.getBookingId());
			dto.setCheckIn(booking.getCheckIn());
			dto.setCheckOut(booking.getCheckOut());

			User customer = this.userService.getUserById(booking.getUserId());
			dto.setCustomerName(customer.getFirstName() + " " + customer.getLastName());

			Hotel hotel = this.hotelService.fetchHotel(booking.getHotelId());
			User hotelUser = this.userService.getUserById(hotel.getUserId());
			dto.setHotelEmail(hotelUser.getEmailId());
			dto.setHotelContact(hotelUser.getContact());
			dto.setHotelId(hotel.getId());
			dto.setStatus(booking.getStatus());
			dto.setTotalDay(booking.getTotalDay());
			dto.setTotalRoom(booking.getTotalRoom());
			dto.setUserId(customer.getId());
			dto.setHotelName(hotel.getName());
			/*
			 * dto.setHotelImage(hotel.getImage1());
			 */			dto.setCustomerContact(customer.getContact());
			dto.setTotalAmount(String.valueOf(hotel.getPricePerDay() * booking.getTotalRoom() * booking.getTotalDay()));
			dto.setId(booking.getId());

			bookings.add(dto);
		}

		response.setBookings(bookings);
		response.setResponseCode(ResponseCode.SUCCESS.value());
		response.setResponseMessage("Booking Fetched Successfully");
		return new ResponseEntity(response, HttpStatus.OK);

	}

	@GetMapping("/fetch/id")
	public ResponseEntity<?> fetchBookingById(@RequestParam("bookingId") int bookingId) {
		LOG.info("Recieved request for fetch booking by Id");

		HotelBooking booking = this.bookingService.getBookingById(bookingId);
		
		if(booking == null) {
			throw new BookingNotFoundException();
		}

		BookingDto dto = new BookingDto();

		dto.setBookingId(booking.getBookingId());
		dto.setCheckIn(booking.getCheckIn());
		dto.setCheckOut(booking.getCheckOut());

		User customer = this.userService.getUserById(booking.getUserId());
		dto.setCustomerName(customer.getFirstName() + " " + customer.getLastName());

		Hotel hotel = this.hotelService.fetchHotel(booking.getHotelId());
		User hotelUser = this.userService.getUserById(hotel.getUserId());
		dto.setHotelEmail(hotelUser.getEmailId());
		dto.setHotelContact(hotelUser.getContact());
		dto.setHotelId(hotel.getId());
		dto.setStatus(booking.getStatus());
		dto.setTotalDay(booking.getTotalDay());
		dto.setTotalRoom(booking.getTotalRoom());
		dto.setUserId(customer.getId());
		dto.setHotelName(hotel.getName());
		/* dto.setHotelImage(hotel.getImage1()); */
		dto.setCustomerContact(customer.getContact());
		dto.setTotalAmount(String.valueOf(hotel.getPricePerDay() * booking.getTotalRoom() * booking.getTotalDay()));
		dto.setId(booking.getId());

		return new ResponseEntity(dto, HttpStatus.OK);

	}

	@GetMapping("/fetch/bookings")
	public ResponseEntity<?> fetchMyHotelBooking(@RequestParam("hotelId") int hotelId) {
		LOG.info("Recieved request for fetch all booking");

		BookingDetailDto response = new BookingDetailDto();

		List<BookingDto> bookings = new ArrayList<>();

		List<HotelBooking> allBookings = this.bookingService.getMyHotelBookings(hotelId);

		for (HotelBooking booking : allBookings) {

			BookingDto dto = new BookingDto();

			dto.setBookingId(booking.getBookingId());
			dto.setCheckIn(booking.getCheckIn());
			dto.setCheckOut(booking.getCheckOut());

			User customer = this.userService.getUserById(booking.getUserId());
			dto.setCustomerName(customer.getFirstName() + " " + customer.getLastName());

			Hotel hotel = this.hotelService.fetchHotel(booking.getHotelId());
			User hotelUser = this.userService.getUserById(hotel.getUserId());
			dto.setHotelEmail(hotelUser.getEmailId());
			dto.setHotelContact(hotelUser.getContact());
			dto.setHotelId(hotel.getId());
			dto.setStatus(booking.getStatus());
			dto.setTotalDay(booking.getTotalDay());
			dto.setTotalRoom(booking.getTotalRoom());
			dto.setUserId(customer.getId());
			dto.setHotelName(hotel.getName());
			/* dto.setHotelImage(hotel.getImage1()); */
			dto.setCustomerContact(customer.getContact());
			dto.setTotalAmount(String.valueOf(hotel.getPricePerDay() * booking.getTotalRoom() * booking.getTotalDay()));
			dto.setId(booking.getId());

			bookings.add(dto);
		}

		response.setBookings(bookings);
		response.setResponseCode(ResponseCode.SUCCESS.value());
		response.setResponseMessage("Booking Fetched Successfully");
		return new ResponseEntity(response, HttpStatus.OK);

	}

	@GetMapping("/fetch/status")

	public ResponseEntity<?> fetchAllBookingStatus() {
		LOG.info("Recieved request for fetch all booking status");

		List<String> response = new ArrayList<>();

		for (Constants.BookingStatus status : Constants.BookingStatus.values()) {
			response.add(status.value());
		}

		return new ResponseEntity(response, HttpStatus.OK);

	}

	@PostMapping("/update/status")

	public ResponseEntity<?> updateHotelBookingStatus(@RequestBody UpdateBookingStatusRequestDto request) {

		LOG.info("Recieved request for updating the Hotel Booking Status");

		CommanApiResponse response = new CommanApiResponse();

		HotelBooking b = this.bookingService.getBookingById(request.getBookingId());
		
		if(b == null) {
			throw new BookingNotFoundException();
		}

		if (request.getStatus().equals("") || request.getStatus() == null) {
			response.setResponseCode(ResponseCode.FAILED.value());
			response.setResponseMessage("Booking Status can not be empty");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}
		
		b.setStatus(request.getStatus());
		this.bookingService.bookHotel(b);

		response.setResponseCode(ResponseCode.SUCCESS.value());
		response.setResponseMessage("Booking Status Updated");
		return new ResponseEntity(response, HttpStatus.OK);

	}

}

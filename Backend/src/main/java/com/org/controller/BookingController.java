package com.org.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
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

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Booking;
import com.org.service.BookingService;

@CrossOrigin("http://localhost:4200")
@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired(required= true)
	BookingService bookingService;


	@Autowired(required= true)
	RazorpayClient razorpayClient;



	@PostMapping("/createBooking")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public String addBooking(@RequestBody Booking newBooking) {

		bookingService.createBooking(newBooking);

		return "booking successfully";
	}
	//create capacity
	//cancel capacity decrease

	@GetMapping("/readAllBookings")
	public Iterable<Booking> readAllBookings() {

		return bookingService.displayAllBooking();
	}


	@PutMapping("/updateBooking")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyBooking(@RequestBody Booking updateBooking) {

		bookingService.updateBooking(updateBooking);
	}

	@GetMapping("/searchBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") Integer bookingId) {

		return bookingService.findBookingById(bookingId);
	}

	@GetMapping("/searchBookingByUserId/{userId}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Iterable<Booking>  searchBookingByUserID(@PathVariable("userId") Integer UserId) {

		return bookingService.findBookingByUserId(UserId);
	}


	@DeleteMapping("/deleteBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public String deleteBookingByID(@PathVariable("id") Integer bookingId) {

		bookingService.deleteBooking(bookingId);
		return "booking cancel successfllly";
	}
	@GetMapping("/payment")
    public String payment()
    {
		try {
			JSONObject options = new JSONObject();
			options.put("amount", 1000); // Amount in paise (Indian currency)
			options.put("currency", "INR");
			options.put("receipt", "order_receipt_123");

			Order order = razorpayClient.orders.create(options);
			System.out.println(order);
			return "yes successfully  cretaed";
		} catch (RazorpayException e) {
			return "failed";
		}

    }
}

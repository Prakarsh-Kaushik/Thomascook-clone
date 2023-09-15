package com.org.service;

import java.util.List;
import java.util.Optional;

import com.org.dao.FlightDao;
import com.org.model.Flight;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.BookingDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Booking;

@Service
public class BookingServiceImpl implements BookingService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	BookingDao bookingDao;
	@Autowired
	FlightDao flightDao;
	@Autowired(required= true)
	RazorpayClient razorpayClient;

	/*
	 * making new Booking
	 */
	/*@Override
	public ResponseEntity<Booking> createBooking(Booking newBooking) {

		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				Optional<Flight> flight = flightDao.findById(newBooking.getFlightId());
				Flight flight1 = flight.get();
				Integer businessCapacity = flight1.getBusinessCapacity();
				Integer economyCapacity = flight1.getEconomyCapacity();
				Integer firstCapacity = flight1.getFirstCapacity();
				Integer economyPremiumCapacity = flight1.getEconomyPremiumCapacity();
				if(newBooking.getBusinessCount()>businessCapacity || newBooking.getEconomyCount()>economyCapacity || newBooking.getEconomyPremiumCount()>economyPremiumCapacity || newBooking.getFirstCount()>firstCapacity)
				{
					throw new RecordAlreadyPresentException(
							"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
				}
				else {
					flight1.setBusinessCapacity(businessCapacity-=newBooking.getBusinessCount());
					flight1.setEconomyCapacity(economyCapacity-=newBooking.getEconomyCount());
					flight1.setFirstCapacity(firstCapacity-=newBooking.getFirstCount());
					flight1.setEconomyPremiumCapacity(economyPremiumCapacity-=newBooking.getEconomyPremiumCount());
					bookingDao.save(newBooking);
					System.out.println("flight1");


				}





				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
	@Override
	public ResponseEntity<Booking> createBooking(Booking newBooking) {

		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				Optional<Flight> flight = flightDao.findById(newBooking.getFlightId());
				Flight flight1 = flight.get();
				Integer businessCapacity = flight1.getBusinessCapacity();
				Integer economyCapacity = flight1.getEconomyCapacity();
				Integer firstCapacity = flight1.getFirstCapacity();
				Integer economyPremiumCapacity = flight1.getEconomyPremiumCapacity();
				Integer bookingBusinessCount=newBooking.getBusinessCount();
				Integer bookingEconomyCount=newBooking.getEconomyCount();
				Integer bookingEconomyPremiumCount=newBooking.getEconomyPremiumCount();
				Integer bookingFirstCount=newBooking.getFirstCount();
				String flightType=flight1.getFlightType();

				if(bookingBusinessCount>businessCapacity ||bookingEconomyCount>economyCapacity
						|| bookingEconomyPremiumCount>economyPremiumCapacity
						||bookingFirstCount>firstCapacity)
				{
					throw new RecordAlreadyPresentException(
							"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
				}
				else {

					Double totalFare=0.0;
					flight1.setBusinessCapacity(businessCapacity-=newBooking.getBusinessCount());
					flight1.setEconomyCapacity(economyCapacity-=newBooking.getEconomyCount());
					flight1.setFirstCapacity(firstCapacity-=newBooking.getFirstCount());
					flight1.setEconomyPremiumCapacity(economyPremiumCapacity-=newBooking.getEconomyPremiumCount());
					totalFare= (bookingBusinessCount*flight1.getBusinessPrice())
							+ (bookingEconomyCount*flight1.getEconomyPrice())
							+(bookingEconomyPremiumCount*flight1.getEconomyPremiumPrice())+ (bookingFirstCount*flight1.getFirstPrice());
					if(flightType.equals("Round Trip"))
					{
						totalFare=totalFare*1.8;
					}
					newBooking.setFare(totalFare);
					payment(totalFare);
					/*try {
						JSONObject options = new JSONObject();
						options.put("amount", ); // Amount in paise (Indian currency)
						options.put("currency", "INR");
						options.put("receipt", "order_receipt_123");

						Order order = razorpayClient.orders.create(options);
						System.out.println(order);
						bookingDao.save(newBooking);

					} catch (RazorpayException e) {
							throw new
					}*/
					bookingDao.save(newBooking);
					System.out.println("flight1");
				}





				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * update booking made
	 */
	@Override
	public Booking updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingDao.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingDao.save(changedBooking);
		} else
			throw new RecordNotFoundException(
					"Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		return changedBooking;
	}

	/*
	 * deleteing the booking
	 */
	@Override
	public String deleteBooking(Integer bookingId) {

		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		Booking booking = findBookingById.get();
		if (booking!=null) {
			Optional<Flight> flight = flightDao.findById(booking.getFlightId());
			Flight flight1 = flight.get();
			Integer businessCapacity = flight1.getBusinessCapacity();
			Integer economyCapacity = flight1.getEconomyCapacity();
			Integer firstCapacity = flight1.getFirstCapacity();
			Integer economyPremiumCapacity = flight1.getEconomyPremiumCapacity();
			Integer bookingBusinessCount=booking.getBusinessCount();
			Integer bookingEconomyCount=booking.getEconomyCount();
			Integer bookingEconomyPremiumCount=booking.getEconomyPremiumCount();
			Integer bookingFirstCount=booking.getFirstCount();
			flight1.setBusinessCapacity(businessCapacity+bookingBusinessCount);
			flight1.setEconomyCapacity(economyCapacity+bookingEconomyCount);
			flight1.setEconomyPremiumCapacity(economyPremiumCapacity+bookingEconomyPremiumCount);
			flight1.setFirstCapacity(firstCapacity+bookingFirstCount);
			bookingDao.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingID");
	}

	/*@Override
	public String deleteBooking(Integer bookingId) {

		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingDao.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingID");
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.service.BookingService#displayAllBooking() show all booking
	 */
	@Override
	public Iterable<Booking> displayAllBooking() {

		return bookingDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.service.BookingService#findBookingById(java.math.BigInteger)
	 * find booking by ID
	 */
	@Override
	public ResponseEntity<?> findBookingById(Integer bookingId) {
		Optional<Booking> findById = bookingDao.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + bookingId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	/*@Override
	public ResponseEntity<?> findBookingBydstplace(String dstPlace) {
		Optional<Booking> findByDstPlace = bookingDao.findByDstPlace(dstPlace);
		try {
			if (findByDstPlace.isPresent()) {
				Booking findBooking = findByDstPlace.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with DstPlace " + dstPlace);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}*/
	@Override
	public Iterable<Booking> findBookingByUserId(Integer userId) {
		Optional<List<Booking>> findById = bookingDao.findBookingByUserId(userId);
		try {
			if (findById.isPresent()) {
				List<Booking> findBooking = findById.get();

				return findBooking;
			} else
				throw new RecordNotFoundException("No record found with user ID " + userId);
		} catch (RecordNotFoundException e) {
			throw new RecordNotFoundException("No record found with user ID " + userId);
		}
	}


	public String payment(Double amount)
	{
		try {
			JSONObject options = new JSONObject();
			options.put("amount", amount); // Amount in paise (Indian currency)
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

package com.org.controller;

import java.util.ArrayList;
import java.util.List;

import com.org.dto.CommanApiResponse;
import com.org.dto.HotelReviewDto;
import com.org.dto.HotelReviewResponseDto;
import com.org.model.HotelReview;
import com.org.model.User;
import com.org.service.HotelReviewService;
import com.org.service.HotelService;
import com.org.service.UserService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.org.utility.Constants.ResponseCode;




import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/hotel/review")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelReviewController {
	Logger LOG = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelService hotelService;

	@Autowired
	private HotelReviewService hotelReviewService;
	
    @Autowired
    private UserService userService;
	
	@PostMapping("add")

	public ResponseEntity<?> register(@RequestBody HotelReview review) {
		LOG.info("Recieved request for Add Hotel Review");

		CommanApiResponse response = new CommanApiResponse();

		if (review == null) {
			response.setResponseCode(ResponseCode.FAILED.value());
			response.setResponseMessage("Failed to add review");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}
		
		HotelReview hotelReview = hotelReviewService.addHotelReview(review);
		
		if (hotelReview != null) {
			response.setResponseCode(ResponseCode.SUCCESS.value());
			response.setResponseMessage("Hotel Review Added Successfully");
			return new ResponseEntity(response, HttpStatus.OK);
		}

		else {
			response.setResponseCode(ResponseCode.FAILED.value());
			response.setResponseMessage("Failed to add Hotel");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("fetch")

	public ResponseEntity<?> fetchHotelReview(@RequestParam("hotelId") int hotelId) {
		LOG.info("Recieved request for Fetch Hotel Reviews for Hotel Id : "+hotelId);

		HotelReviewResponseDto response = new HotelReviewResponseDto();

		List<HotelReview> reviews = hotelReviewService.fetchHotelReviews(hotelId);
		
		List<HotelReviewDto> reviewDto = new ArrayList<>();
		
		for(HotelReview review : reviews) {
			
			User user = userService.getUserById(review.getUserId());
			
			reviewDto.add(new HotelReviewDto(user.getFirstName(), review.getStar(), review.getReview()));
			
		}
		
		
		try {
			response.setHotelReviews(reviewDto);
			response.setResponseCode(ResponseCode.SUCCESS.value());
			response.setResponseMessage("Hotel Reviews Fetched Successfully");
			return new ResponseEntity(response, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Exception Caught");
			response.setResponseCode(ResponseCode.FAILED.value());
			response.setResponseMessage("Failed to Fetch Hotel Reviews");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}

package com.org.service;

import java.util.List;

import com.org.dao.HotelReviewDao;
import com.org.model.HotelReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelReviewService {
	@Autowired
	private HotelReviewDao hotelReviewDao;
	
	public HotelReview addHotelReview(HotelReview review) {
		return hotelReviewDao.save(review);
	}
	
	public List<HotelReview> fetchHotelReviews(int hotelId) {
		return hotelReviewDao.findByHotelId(hotelId);
	}
}

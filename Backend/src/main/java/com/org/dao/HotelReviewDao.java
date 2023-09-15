package com.org.dao;

import java.util.List;

import com.org.model.HotelReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelReviewDao extends JpaRepository<HotelReview, Integer>{
	List<HotelReview> findByHotelId(int hotelId);
}

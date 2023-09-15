package com.org.dto;

import java.util.List;



public class HotelReviewResponseDto extends CommanApiResponse{
	private List<HotelReviewDto> hotelReviews;

	public List<HotelReviewDto> getHotelReviews() {
		return hotelReviews;
	}

	public void setHotelReviews(List<HotelReviewDto> hotelReviews) {
		this.hotelReviews = hotelReviews;
	}
}

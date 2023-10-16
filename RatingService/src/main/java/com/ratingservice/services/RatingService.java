package com.ratingservice.services;

import java.util.List;

import com.ratingservice.entity.Rating;

public interface RatingService {
	
	//create rating
	public Rating createRating(Rating rating);
	
	//get All ratings
	public List<Rating> getAllRatings();
	
	//get Rating by User Id
	public List<Rating> getAllRatingByUserId(Integer userId);
	
	//get Rating by Hotel Id
	public List<Rating> getAllRatingByHotelId(Integer hotelId);
}

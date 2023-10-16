package com.ratingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.entity.Rating;
import com.ratingservice.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		
		return this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUserId(Integer userId) {
		
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(Integer hotelId) {
		
		return this.ratingRepository.findByHotelId(hotelId);
	}

}

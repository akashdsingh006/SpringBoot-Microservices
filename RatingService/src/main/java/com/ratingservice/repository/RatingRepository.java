package com.ratingservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratingservice.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating, Integer>{

	List<Rating> findByUserId(Integer userId);
	
	List<Rating> findByHotelId(Integer hotelId);
}

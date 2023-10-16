package com.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.entity.Rating;
import com.ratingservice.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<List<Rating>> getAllRatings()
	{
		return ResponseEntity.ok(this.ratingService.getAllRatings());
	}
	
	@GetMapping(path="/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.ratingService.getAllRatingByUserId(userId));
	}
	
	@GetMapping(path="/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable Integer hotelId)
	{
		return ResponseEntity.ok(this.ratingService.getAllRatingByHotelId(hotelId));
	}
	
}

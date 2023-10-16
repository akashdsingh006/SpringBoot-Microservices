package com.hotelservice.controller;

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

import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		this.hotelService.addHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Hotel>> getAllHotels()
	{
		return ResponseEntity.ok(this.hotelService.getAllHotel());
	}
	
	@GetMapping(path = "/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable Integer hotelId) throws ResourceNotFoundException
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.hotelService.getHotel(hotelId));
	}
}

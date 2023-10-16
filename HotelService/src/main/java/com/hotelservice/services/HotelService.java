package com.hotelservice.services;

import java.util.List;

import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.ResourceNotFoundException;

public interface HotelService {
	public Hotel addHotel(Hotel hotel);

	public List<Hotel> getAllHotel();

	public Hotel getHotel(Integer hotelId) throws ResourceNotFoundException;
}

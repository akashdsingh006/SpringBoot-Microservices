package com.hotelservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel addHotel(Hotel hotel) {
		
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(Integer hotelId) throws ResourceNotFoundException {
		return this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException());
	}

}

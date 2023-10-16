package com.user.service.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.model.Hotel;
import com.user.service.model.Rating;
import com.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User addUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		return this.userRepository.findAll();
	}

	@Override
	public User getUser(Integer userId) throws ResourceNotFoundException {

		// get User Information for given userId
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for the userId: " + userId));

		// fetch the Rating of any user from http://localhost:8083/ratings/users/1
		// Use RestTemplate to fetch data from the Rating Service
		Rating[] ratingForUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId,
				Rating[].class);
		// user.setUserRatings(ratingForUser);

		List<Rating> ratingList = Arrays.stream(ratingForUser).toList();
		List<Rating> ratingWithHotels = ratingList.stream().map(rating -> {
			Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setUserRatings(ratingWithHotels);
		return user;
	}

	@Override
	public boolean updateUser(Integer userId, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
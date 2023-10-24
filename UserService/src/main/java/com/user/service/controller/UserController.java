package com.user.service.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.services.UserService;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User addUser = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(addUser);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	int retryCount=1;
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker" , fallbackMethod = "ratingHotelFallback")
	//@Retry(name="ratingHotelService" , fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable Integer userId) throws ResourceNotFoundException
	{
		User user = userService.getUser(userId);
		logger.info("Retry count {}",retryCount++);
		return ResponseEntity.ok(user);
	}
	
	//Creating fallback method when a service is down
	public ResponseEntity<User> ratingHotelFallback(Integer userId ,Exception ex)
	{
		User user=User.builder()
				  .userId(12345)
				  .userName("Test")
				  .userEmail("test@gmail.com")
				  .phoneNumber(7896541230L)
				  .build();
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}

package com.user.service.services;

import java.util.List;

import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;

public interface UserService {

	// Create
	public User addUser(User user);

	// Get List of All Users
	public List<User> getAllUsers();

	// Get particular User
	public User getUser(Integer userId) throws ResourceNotFoundException;

	// Update user
	public boolean updateUser(Integer userId, User user);

	// Delete User
	public boolean deleteUser(Integer userId);
}

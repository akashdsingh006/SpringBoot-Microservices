package com.user.service.exceptions;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource not found for this server");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}

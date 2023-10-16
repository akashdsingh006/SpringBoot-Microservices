package com.hotelservice.exception;


public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = -1905601296819069806L;

	public ResourceNotFoundException()
	{
		super("No hotel found for this id");
	}
}

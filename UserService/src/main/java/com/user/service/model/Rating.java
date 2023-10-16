package com.user.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rating {
	
	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer rating;
	private String remarks;
	private Hotel hotel;
}

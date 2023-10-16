 package com.ratingservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document("ratings")
public class Rating {

	@Id
	@Field("ratingId")
	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer rating;
	private String remarks;
}
package com.user.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

	private Integer hotelId;
	private String hotelName;
	private String hotelLocation;
	private String hotelRemarks;

}

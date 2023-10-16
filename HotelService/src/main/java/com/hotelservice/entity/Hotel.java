package com.hotelservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotels")
public class Hotel {

	@Id
	@Column(name = "hotel_id")
	private Integer hotelId;
	
	@Column(name = "hotel_name")
	private String hotelName;
	
	@Column(name = "hotel_location")
	private String hotelLocation;
	
	@Column(name = "hotel_remarks")
	private String hotelRemarks;
}

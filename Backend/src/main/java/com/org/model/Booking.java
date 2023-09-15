package com.org.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Booking {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int bookingId;
	private String bookingDate;
	private int noOfPassengers;
	private Integer userId;
	private int flightId;


	private Integer passengerCountInfant;
	private Integer passengerCountChild;
	private Integer passengerCountAdult;
	private Integer economyCount;
	private Integer businessCount;
	private Integer firstCount;
	private Integer economyPremiumCount;

	private Double fare;


}

package com.org.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	@Id
	private Integer flightId;
	private String carrierName;
	private String flightModel;
	private String flightType;
	private Integer economyCapacity;
	private Integer businessCapacity;
	private Integer firstCapacity;
	private Integer economyPremiumCapacity;
	private Double economyPrice;
	private Double businessPrice;
	private Double firstPrice;
	private Double economyPremiumPrice;
	@ManyToOne
	@JoinColumn(name = "departure_airport_id")
	private Airport departureAirport;

	@ManyToOne
	@JoinColumn(name = "arrival_airport_id")
	private Airport arrivalAirport;

	private Date departureDatetime;
	private Date arrivalDatetime;
	/*@OneToOne(mappedBy = "airport",fetch = FetchType.EAGER)
	private Airport dstnAirport;*/




	

}

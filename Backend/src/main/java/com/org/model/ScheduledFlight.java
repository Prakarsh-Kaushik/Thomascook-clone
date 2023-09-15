/*
package com.org.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigInteger;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduledFlight {

	@Id
	@Column(name = "schedule_flight_id")
	private BigInteger scheduleFlightId;

	@OneToOne(fetch = FetchType.EAGER)
	@NotNull
	private Flight flight;

	@Column(name = "available_seats")
	@NotNull
	private Integer availableSeats;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;

	*/
/*
	 * Default constructor
	 *//*



}
*/

package com.org.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Flight;
@Repository
public interface FlightDao extends CrudRepository<Flight,Integer>{
    @Query("SELECT f FROM Flight f " +
            "JOIN f.departureAirport da " +
            "JOIN f.arrivalAirport aa " +
            "WHERE da.airportLocation = :departureCity " +
            "AND aa.airportLocation = :arrivalCity " +
            "AND DATE(f.departureDatetime) = :departureDate " +
            "AND (DATE(f.arrivalDatetime) = :arrivalDate OR :arrivalDate IS NULL)")
    List<Flight> searchFlightsByCitiesAndDates(
            String departureCity,
            String arrivalCity,
            LocalDate departureDate,
            LocalDate arrivalDate
    );

    @Query("SELECT f FROM Flight f " +
            "JOIN f.departureAirport da " +
            "JOIN f.arrivalAirport aa " +
            "WHERE da.airportLocation = :departureCity " +
            "AND aa.airportLocation= :arrivalCity " +
            "AND DATE(f.departureDatetime) = :departureDate")
    List<Flight> searchOneWayFlightsByCitiesAndDates(
            String departureCity,
            String arrivalCity,
            LocalDate departureDate
    );
}



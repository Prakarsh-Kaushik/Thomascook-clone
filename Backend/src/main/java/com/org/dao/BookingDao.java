package com.org.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, Integer> {

    /*Optional<Booking> findByDstPlace(String dstPlace);*/

    Optional<List<Booking>> findBookingByUserId(Integer userId);
}

package com.org.dao;

import com.org.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FacilityDao extends JpaRepository<Facility, Integer> {

}

package com.org.dao;

import com.org.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationDao extends JpaRepository<Location, Integer> {

}

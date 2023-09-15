package com.org.dao;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.org.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao  extends JpaRepository<User, Integer> {
    User findByEmailIdAndPassword(String emailId, String password);
    User findByEmailIdAndPasswordAndRole(String emailId, String password, String role);
    User findByEmailIdAndRole(String emailId, String role);
    User findByEmailId(String emailId);
    List<User> findByRoleAndHotelId(String role, int hotelId);
}
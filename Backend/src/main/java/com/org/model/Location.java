package com.org.model;
import java.util.List;

import com.org.dto.LocationFetchResponse;
import jakarta.persistence.OneToMany;

import org.springframework.beans.BeanUtils;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String city;

	private String description;

	@OneToMany
	private List<Hotel> hotels;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public static LocationFetchResponse toLocationFetchResponse(Location location) {
		LocationFetchResponse locationFetchResponse = new LocationFetchResponse();
		BeanUtils.copyProperties(location, locationFetchResponse);
		return locationFetchResponse;
	}
}

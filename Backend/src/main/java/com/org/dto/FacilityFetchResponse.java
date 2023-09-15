package com.org.dto;

import com.org.model.Facility;

import java.util.Set;




public class FacilityFetchResponse extends CommanApiResponse{
	private Set<Facility> facilities;

	public Set<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}
}

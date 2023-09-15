package com.org.dto;

import com.org.model.Location;

import java.util.List;



public class LocationFetchResponse extends CommanApiResponse {
	 private List<Location> locations;

		public List<Location> getLocations() {
			return locations;
		}

		public void setLocations(List<Location> locations) {
			this.locations = locations;
		}
	    
}

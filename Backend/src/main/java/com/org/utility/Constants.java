package com.org.utility;

public class Constants {
	
	public enum UserRole {
		ADMIN("Admin"),
		CUSTOMER("Customer"),
		HOTEL("Hotel");
		
		
		private String role;

	    private UserRole(String role) {
	      this.role = role;
	    }

	    public String value() {
	      return this.role;
	    }    
	}
	
	public enum Sex {
		MALE("Male"),
		FEMALE("Female");
		
		
		private String sex;

	    private Sex(String sex) {
	      this.sex = sex;
	    }

	    public String value() {
	      return this.sex;
	    }    
	}
	
	public enum BookingStatus {
		APPROVED("Approved"),
		PENDING("Pending"),
		CANCEL("Cancel");
		
		
		private String status;

	    private BookingStatus(String status) {
	      this.status = status;
	    }

	    public String value() {
	      return this.status;
	    }    
	}
	
	public enum RoomStatus {
		FULL("Full"),
		AVAILABLE("Available");
		
		
		private String status;

	    private RoomStatus(String status) {
	      this.status = status;
	    }

	    public String value() {
	      return this.status;
	    }    
	}
	
	public enum ResponseCode {
		SUCCESS(0),
		FAILED(1);
		
		
		private int code;

	    private ResponseCode(int code) {
	      this.code = code;
	    }

	    public int value() {
	      return this.code;
	    }    
	}
	
}

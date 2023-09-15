package com.org.dto;

import java.util.List;



public class UserRoleResponse extends CommanApiResponse{
private List<String> roles;
	
	private List<String> genders;

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}
}

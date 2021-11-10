package com.auctionapp.api.model.dto;

import com.auctionapp.api.model.entities.UserRoleEnum;

public class AuthenticationResponse {
	private String authenticationToken;
	private String email;
	private UserRoleEnum userRole;

	public AuthenticationResponse() {
	}

	public AuthenticationResponse(String authenticationToken, String email, UserRoleEnum userRole) {
		this.authenticationToken = authenticationToken;
		this.email = email;
		this.userRole = userRole;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoleEnum getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleEnum userRole) {
		this.userRole = userRole;
	}
}

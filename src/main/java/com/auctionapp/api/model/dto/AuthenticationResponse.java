package com.auctionapp.api.model.dto;

import com.auctionapp.api.model.entities.UserRoleEnum;

public class AuthenticationResponse {
	private final String authenticationToken;
	private final String email;
	private final UserRoleEnum userRole;

	public AuthenticationResponse(final String authenticationToken, 
								  final String email, 
								  final UserRoleEnum userRole) {
		this.authenticationToken = authenticationToken;
		this.email = email;
		this.userRole = userRole;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}


	public String getEmail() {
		return email;
	}

	public UserRoleEnum getUserRole() {
		return userRole;
	}
}

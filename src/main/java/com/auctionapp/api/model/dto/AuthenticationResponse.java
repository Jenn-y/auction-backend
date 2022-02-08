package com.auctionapp.api.model.dto;

import java.util.UUID;

import com.auctionapp.api.model.entities.UserRole;

public class AuthenticationResponse {
	private final String authenticationToken;
	private final UUID id;
	private final String email;
	private final UserRole userRole;

	public AuthenticationResponse(final String authenticationToken,
								  final UUID id, 
								  final String email, 
								  final UserRole userRole) {
		this.authenticationToken = authenticationToken;
		this.id = id;
		this.email = email;
		this.userRole = userRole;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public UUID getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public UserRole getUserRole() {
		return userRole;
	}
}

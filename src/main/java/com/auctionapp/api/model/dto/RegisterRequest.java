package com.auctionapp.api.model.dto;

public class RegisterRequest {
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String password;

	public RegisterRequest(final String firstName, 
						   final String lastName, 
						   final String email, 
						   final String password) {
							   
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}

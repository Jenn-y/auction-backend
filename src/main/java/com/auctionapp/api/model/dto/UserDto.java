package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class UserDto {
	private final UUID id;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String password;
	private final Timestamp createdAt;
	private final Timestamp updatedAt;

	public UserDto(final UUID id, 
				  final String firstName, 
				  final String lastName, 
				  final String email, 
				  final String password,
				  final Timestamp createdAt, 
				  final Timestamp updatedAt) {
					  
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getUuid() {
		return id;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
}

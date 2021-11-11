package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class UserDto {
	private UUID id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public UserDto() {}

	public UserDto(final UUID id, 
				  final String firstName, 
				  final String lastName, 
				  final String username, 
				  final String email, 
				  final String password,
				  final Timestamp createdAt, 
				  final Timestamp updatedAt) {
					  
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
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

	public String getUsername() {
		return username;
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

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setCreatedAt(final Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(final Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}

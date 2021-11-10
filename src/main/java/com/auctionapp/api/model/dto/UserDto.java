package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class UserDto {
	private UUID uuid;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public UserDto() {
	}

	public UserDto(UUID uuid, String firstName, String lastName, String username, String email, String password,
			Timestamp createdAt, Timestamp updatedAt) {
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}

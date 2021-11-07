package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private UUID uuid;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}

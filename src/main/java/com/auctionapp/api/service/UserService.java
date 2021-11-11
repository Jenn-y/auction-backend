package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.model.entities.User;

public class UserService {

	public static User fromPayload(UserDto payload) {
		User user = new User();
		if (payload.getUuid() != null)
			user.setUuid(payload.getUuid());
		user.setEmail(payload.getEmail());
		user.setFirstName(payload.getFirstName());
		user.setLastName(payload.getLastName());
		user.setPassword(payload.getPassword());
		user.setCreatedAt(payload.getCreatedAt());
		user.setUpdatedAt(payload.getUpdatedAt());
		return user;
	}

	public static UserDto toPayload(User user) {
		UserDto payload = new UserDto();
		payload.setId(user.getUuid());
		payload.setEmail(user.getEmail());
		payload.setFirstName(user.getFirstName());
		payload.setLastName(user.getLastName());
		payload.setPassword(user.getPassword());
		payload.setCreatedAt(user.getCreatedAt());
		payload.setUpdatedAt(user.getUpdatedAt());
		return payload;
	}
}

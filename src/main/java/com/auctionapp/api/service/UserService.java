package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.model.entities.User;

public class UserService {

	public static User fromPayload(UserDto payload) {
		User user = new User(payload.getUuid(),
							payload.getFirstName(),
							payload.getLastName(),
							payload.getEmail(),
							payload.getPassword(),
							payload.getCreatedAt(),
							payload.getUpdatedAt(),
							payload.getRole()
							);
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

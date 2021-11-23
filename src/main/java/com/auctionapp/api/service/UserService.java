package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.model.entities.User;

public class UserService {

	public static User fromPayload(final UserDto payload) {
		User user = new User(payload.getId(),
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

	public static UserDto toPayload(final User user) {
		UserDto payload = new UserDto(
                                      user.getUuid(),
                                      user.getFirstName(),
                                      user.getLastName(),
                                      user.getEmail(),
                                      user.getPassword(),
                                      user.getCreatedAt(),
                                      user.getUpdatedAt(),
									  user.getRole()
                                      );
		return payload;
	}
}

package com.auctionapp.api.service;

import java.util.Optional;

import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.model.entities.User;
import com.auctionapp.api.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDto getUser(String email) {
		Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) return toPayload(user.get());
        throw new RuntimeException("User with email " + email + " does not exist!");
	}

	public static User fromPayload(UserDto payload) {
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

	public static UserDto toPayload(User user) {
		UserDto payload = new UserDto(
                                      user.getUuid(),
                                      user.getFirstName(),
                                      user.getLastName(),
                                      user.getEmail(),
                                      user.getPassword(),
                                      user.getCreatedAt(),
                                      user.getUpdatedAt()
                                      );
		return payload;
	}
}

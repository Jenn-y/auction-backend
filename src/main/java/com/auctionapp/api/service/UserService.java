package com.auctionapp.api.service;

import java.util.Optional;
import java.util.UUID;

import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.model.entities.Status;
import com.auctionapp.api.model.entities.User;
import com.auctionapp.api.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDto getUser(final String email) {
		Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
			return toPayload(user.get());
		}
        throw new RuntimeException("User with email " + email + " does not exist!");
	}

	public void deactivateUser(final UUID id) {
		Optional<User> user = userRepository.findById(id);
		user.get().setStatus(Status.INACTIVE);
		userRepository.save(user.get());
	}

	public static User fromPayload(final UserDto payload) {
		User user = new User(payload.getId(),
							payload.getFirstName(),
							payload.getLastName(),
							payload.getEmail(),
							payload.getPassword(),
							payload.getCreatedAt(),
							payload.getUpdatedAt(),
							payload.getRole(),
							payload.getStatus()
							);
		return user;
	}

	public static UserDto toPayload(final User user) {
		UserDto payload = new UserDto(
                                      user.getId(),
                                      user.getFirstName(),
                                      user.getLastName(),
                                      user.getEmail(),
                                      user.getPassword(),
                                      user.getCreatedAt(),
                                      user.getUpdatedAt(),
									  user.getRole(),
									  user.getStatus()
                                      );
		return payload;
	}
}

package com.auctionapp.api.service;

import java.util.Optional;
import java.util.UUID;

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

	public UserDto getUser(final String email) {
		Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
			return toPayload(user.get());
		}
        throw new RuntimeException("User with email " + email + " does not exist!");
	}

	public UserDto getUserById(final UUID id) {
		Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
			return toPayload(user.get());
		}
        throw new RuntimeException("User with id " + id + " does not exist!");
	}

	public void deactivateUser(final UUID id) {
		userRepository.deactivateUser(id);
	}

	public UserDto update(UUID id, UserDto user) {
        User updatedUser = fromPayload(user);
        updatedUser = userRepository.save(updatedUser);
        return toPayload(updatedUser);
	}

	public static User fromPayload(final UserDto payload) {
		User user = new User(payload.getId(),
							payload.getFirstName(),
							payload.getLastName(),
							payload.getEmail(),
							payload.getPassword(),
							payload.getPhoneNum(),
							payload.getGender(),
							payload.getDateOfBirth(),
							payload.getCreatedAt(),
							payload.getUpdatedAt(),
							payload.getRole(),
							payload.getStatus()
							);
		if (payload.getPaymentDetails() != null) {
			user.setPaymentDetails(PaymentDetailsService.fromPayload(payload.getPaymentDetails()));
		}
		if (payload.getShippingDetails() != null) {
			user.setShippingDetails(ShippingDetailsService.fromPayload(payload.getShippingDetails()));
		}
		return user;
	}

	public static UserDto toPayload(final User user) {
		UserDto payload = new UserDto(
                                      user.getId(),
                                      user.getFirstName(),
                                      user.getLastName(),
                                      user.getEmail(),
                                      user.getPassword(),
									  user.getPhoneNum(),
									  user.getGender(),
									  user.getDateOfBirth(),
                                      user.getCreatedAt(),
                                      user.getUpdatedAt(),
									  user.getRole(),
									  user.getStatus()
                                      );
		if (user.getPaymentDetails() != null) {
			payload.setPaymentDetails(PaymentDetailsService.toPayload(user.getPaymentDetails()));
		}
		if (user.getShippingDetails() != null) {
			payload.setShippingDetails(ShippingDetailsService.toPayload(user.getShippingDetails()));
		}
		return payload;
	}
}

package com.auctionapp.api.service;

import java.util.Optional;
import java.util.UUID;

import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.model.entities.Status;
import com.auctionapp.api.model.entities.User;
import com.auctionapp.api.repository.PaymentDetailsRepository;
import com.auctionapp.api.repository.ShippingDetailsRepository;
import com.auctionapp.api.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PaymentDetailsRepository paymentDetailsRepository;
	private final ShippingDetailsRepository shippingDetailsRepository;

	public UserService(final UserRepository userRepository,
					   final PaymentDetailsRepository paymentDetailsRepository,
					   final ShippingDetailsRepository shippingDetailsRepository) {

		this.userRepository = userRepository;
		this.paymentDetailsRepository = paymentDetailsRepository;
		this.shippingDetailsRepository = shippingDetailsRepository;
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

	public UserDto update(UUID id, UserDto user) {
        User updatedUser = fromPayload(user);
        updatedUser = userRepository.save(updatedUser);
		paymentDetailsRepository.save(updatedUser.getPaymentDetails());
		shippingDetailsRepository.save(updatedUser.getShippingDetails());
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

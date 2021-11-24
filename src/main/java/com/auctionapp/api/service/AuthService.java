package com.auctionapp.api.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import com.auctionapp.api.model.dto.AuthenticationResponse;
import com.auctionapp.api.model.dto.LoginRequest;
import com.auctionapp.api.model.dto.RegisterRequest;
import com.auctionapp.api.model.entities.User;
import com.auctionapp.api.model.entities.UserRole;
import com.auctionapp.api.repository.UserRepository;
import com.auctionapp.api.security.JwtProvider;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;

	public AuthService(final PasswordEncoder passwordEncoder, 
						final UserRepository userRepository,
						final AuthenticationManager authenticationManager, 
						final JwtProvider jwtProvider) {

		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.authenticationManager = authenticationManager;
		this.jwtProvider = jwtProvider;
	}

	public String validateRegisterRequest(RegisterRequest registerRequest) {
		if (registerRequest.getFirstName().isEmpty()) { 
			return "First name field must not be empty!";
		} else if (registerRequest.getLastName().isEmpty()) {
			return "Last name field must not be empty!";
		} else if (registerRequest.getEmail().isEmpty()) { 
			return "Email field must not be empty!";
		} else if (!validateEmailAdress(registerRequest.getEmail())) {
			return "Invalid email form!";
		} else if (!isAvailable(registerRequest.getEmail())) {
			return "Email already in use!";
		} else if (registerRequest.getPassword().isEmpty()) {
			return "Password field must not be empty!";
		} else if (registerRequest.getPassword().length() < 6) {
			return "Password must be minimum 6 characters long!";
		}
		return "";
	}

	public boolean validateLoginRequest(LoginRequest loginRequest) {
		if (loginRequest.getEmail().isEmpty()) {
			return false;
		} else if (!validateEmailAdress(loginRequest.getEmail())) {
			return false;
		} else if (loginRequest.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean validateEmailAdress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
 	}

	public boolean isAvailable(String email) {
		if (userRepository.existsByEmail(email)) {
			return false;
		}
		return true;
 	}

	@Transactional
	public String register(final RegisterRequest registerRequest) {
		User user = new User(null,
							registerRequest.getFirstName(),
							registerRequest.getLastName(),
							registerRequest.getEmail(),
							passwordEncoder.encode(registerRequest.getPassword()),
							Timestamp.from(Instant.now()),
							Timestamp.from(Instant.now()),
							UserRole.USER
		);

		if (userRepository.save(user) != null) {
			return "User registration successful";
		}
		return "User registration unsuccessful";
	}

	public AuthenticationResponse login(final LoginRequest loginRequest) {
		Authentication authenticate = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				loginRequest.getEmail(), 
				loginRequest.getPassword()
			)
		);
		
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		String token = jwtProvider.generateToken(authenticate);

		Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
		return new AuthenticationResponse(token, loginRequest.getEmail(), user.get().getRole());
	}
}

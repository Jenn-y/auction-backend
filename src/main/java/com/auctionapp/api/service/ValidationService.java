package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.LoginRequest;
import com.auctionapp.api.model.dto.RegisterRequest;
import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	private final UserRepository userRepository;

	public ValidationService(final UserRepository userRepository) {
		this.userRepository = userRepository;
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
		} else if (!isEmailAvailable(registerRequest.getEmail())) {
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

	public boolean isEmailAvailable(String email) {
		return !userRepository.existsByEmail(email);
 	}

	public boolean validateUserUpdateInfo(UserDto user) {
		if (user.getFirstName().isEmpty() || user.getLastName().isEmpty()
			|| user.getEmail().isEmpty() || user.getGender() == null 
			|| user.getDateOfBirth() == null || user.getPhoneNum().isEmpty()) { 
			return false;
		} else if (!validateEmailAdress(user.getEmail())) {
			return false;
		} 

		return true;
	}
}

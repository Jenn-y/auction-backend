package com.auctionapp.api.model.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import com.auctionapp.api.model.entities.Gender;
import com.auctionapp.api.model.entities.Status;
import com.auctionapp.api.model.entities.UserRole;

public class UserDto {
	private final UUID id;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String password;
	private final String phoneNum;
	private final Gender gender;
	private final Date dateOfBirth;
	private final Timestamp createdAt;
	private final Timestamp updatedAt;
	private final UserRole role;
	private final Status status;
	private final PaymentDetailsDto paymentDetails;
	private final ShippingDetailsDto shippingDetails;

	public UserDto(final UUID id, 
				  final String firstName, 
				  final String lastName, 
				  final String email, 
				  final String password,
				  final String phoneNum,
				  final Gender gender,
				  final Date dateOfBirth,
				  final Timestamp createdAt, 
				  final Timestamp updatedAt,
				  final UserRole role,
				  final Status status,
				  final PaymentDetailsDto paymentDetails,
				  final ShippingDetailsDto shippingDetails) {
					  
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.role = role;
		this.status = status;
		this.paymentDetails = paymentDetails;
		this.shippingDetails = shippingDetails;
	}

	public UUID getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public UserRole getRole() {
		return role;
	}

	public Status getStatus() {
		return status;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public Gender getGender() {
		return gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public PaymentDetailsDto getPaymentDetails() {
		return paymentDetails;
	}

	public ShippingDetailsDto getShippingDetails() {
		return shippingDetails;
	}
}

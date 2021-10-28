package com.auctionapp.api.model.dto;

import com.auctionapp.api.model.entities.UserRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	private String authenticationToken;
	private String email;
	private UserRoleEnum userRole;
}

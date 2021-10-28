package com.auctionapp.api.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class SecurityConstants {

	public static final SecretKey SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	public static final long EXPIRATION_TIME = 900_000; // 15 mins
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}

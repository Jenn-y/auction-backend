package com.auctionapp.api.builder;

import java.util.UUID;

import com.auctionapp.api.model.entities.User;

public class ObjectTestBuilder {
	private static final String FIRST_NAME = "User";
	private static final String LAST_NAME = "One";
	private static final String EMAIL = "userone@gmail.com";
	private static final String PASSWORD = "123456";
	private static final UUID USER_ID = UUID.randomUUID();

	private ObjectTestBuilder() {
		throw new UnsupportedOperationException();
	}

	public static User buildUser() {
		User user = new User();
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmail(EMAIL);
		user.setPassword(PASSWORD);
		user.setUuid(USER_ID);
		return user;
	}

}

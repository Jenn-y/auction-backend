package com.auctionapp.api.builder;

import java.util.UUID;

import com.auctionapp.api.model.entities.User;
import com.auctionapp.api.model.entities.UserRole;

public class ObjectTestBuilder {
	
	private static final String FIRST_NAME = "User";
	private static final String LAST_NAME = "One";
	private static final String EMAIL = "userone@gmail.com";
	private static final String PASSWORD = "123456";
	private static final UserRole ROLE = UserRole.USER;
	private static final UUID USER_ID = UUID.randomUUID();

	private ObjectTestBuilder() {
		throw new UnsupportedOperationException();
	}

	public static User buildUser() {
		User user = new User(USER_ID,
							FIRST_NAME,
							LAST_NAME,
							EMAIL,
							PASSWORD,
							null,
							null,
							ROLE
							);
		return user;
	}

}

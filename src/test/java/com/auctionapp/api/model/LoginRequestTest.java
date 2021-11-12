package com.auctionapp.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.auctionapp.api.model.dto.LoginRequest;

import org.junit.jupiter.api.Test;

public class LoginRequestTest {
    private LoginRequest loginRequest = new LoginRequest("johndoe@gmail.com", "123456");

    @Test
    void getEmail() {
        assertEquals("johndoe@gmail.com", loginRequest.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("123456", loginRequest.getPassword());
    }
}

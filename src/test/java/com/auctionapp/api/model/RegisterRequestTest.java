package com.auctionapp.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.auctionapp.api.model.dto.RegisterRequest;

import org.junit.jupiter.api.Test;

public class RegisterRequestTest {
    private RegisterRequest registerRequest = new RegisterRequest("John", "Doe", "johndoe@email.com", "123456");

    @Test
    void getName() {
        assertEquals("John", registerRequest.getFirstName());
    }

    @Test
    void getSurname() {
        assertEquals("Doe", registerRequest.getLastName());
    }

    @Test
    void getEmail() {
        assertEquals("johndoe@email.com", registerRequest.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("123456", registerRequest.getPassword());
    }
}

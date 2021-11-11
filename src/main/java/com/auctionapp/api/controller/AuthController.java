package com.auctionapp.api.controller;

import com.auctionapp.api.model.dto.AuthenticationResponse;
import com.auctionapp.api.model.dto.LoginRequest;
import com.auctionapp.api.model.dto.RegisterRequest;
import com.auctionapp.api.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        String result = authService.validateRegisterRequest(registerRequest);

        if (result.isEmpty()) { 
            result = authService.register(registerRequest); 
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {

        if (authService.validateLoginRequest(loginRequest)) { 
            AuthenticationResponse result = authService.login(loginRequest);
            return new ResponseEntity<AuthenticationResponse>(result, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
}

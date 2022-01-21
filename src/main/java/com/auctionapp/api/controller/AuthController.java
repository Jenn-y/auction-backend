package com.auctionapp.api.controller;

import com.auctionapp.api.model.dto.AuthenticationResponse;
import com.auctionapp.api.model.dto.LoginRequest;
import com.auctionapp.api.model.dto.RegisterRequest;
import com.auctionapp.api.model.dto.ValidationResponse;
import com.auctionapp.api.service.AuthService;
import com.auctionapp.api.service.ValidationService;

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
    private final ValidationService validationService;

    public AuthController(final AuthService authService, final ValidationService validationService) {
        this.authService = authService;
        this.validationService = validationService;
    }

    @PostMapping("/register")
    public ResponseEntity<ValidationResponse> register(@RequestBody final RegisterRequest registerRequest) {
        String error = validationService.validateRegisterRequest(registerRequest);

        if (error.isEmpty()) {
            ValidationResponse validationResponse = new ValidationResponse(authService.register(registerRequest), true);
            return new ResponseEntity<>(validationResponse, HttpStatus.CREATED);
        }

        ValidationResponse validationResponse = new ValidationResponse(error, false);
        return new ResponseEntity<>(validationResponse, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody final LoginRequest loginRequest) {

        if (validationService.validateLoginRequest(loginRequest)) { 
            AuthenticationResponse result = authService.login(loginRequest);
            return new ResponseEntity<AuthenticationResponse>(result, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
}

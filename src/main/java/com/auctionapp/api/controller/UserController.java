package com.auctionapp.api.controller;

import java.util.UUID;

import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(final UserService userService) {
        this.service = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> get(@PathVariable final String email) {
        UserDto result = service.getUser(email);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<Object> deactivateUser(@PathVariable final UUID id) {
        service.deactivateUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> update(@PathVariable final UUID id,
                                          @RequestBody final UserDto user) {

        final UserDto result = service.update(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

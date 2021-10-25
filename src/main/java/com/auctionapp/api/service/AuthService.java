package com.auctionapp.api.service;

import java.sql.Timestamp;
import java.time.Instant;

import com.auctionapp.api.model.dto.RegisterRequest;
import com.auctionapp.api.model.entities.User;
import com.auctionapp.api.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  
  @Transactional
  public void register(RegisterRequest registerRequest){
    User user = new User();
    user.setFirstName(registerRequest.getFirstName());
    user.setLastName(registerRequest.getLastName());
    user.setEmail(registerRequest.getEmail());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    user.setCreatedAt(Timestamp.from(Instant.now()));
    userRepository.save(user);
  }
}

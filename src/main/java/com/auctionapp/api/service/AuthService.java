package com.auctionapp.api.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import com.auctionapp.api.model.dto.AuthenticationResponse;
import com.auctionapp.api.model.dto.LoginRequest;
import com.auctionapp.api.model.dto.RegisterRequest;
import com.auctionapp.api.model.entities.User;
import com.auctionapp.api.model.entities.UserRoleEnum;
import com.auctionapp.api.repository.UserRepository;
import com.auctionapp.api.security.JwtProvider;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;
  private final JwtProvider jwtProvider;
  
  @Transactional
  public void register(RegisterRequest registerRequest){
    User user = new User();
    user.setFirstName(registerRequest.getFirstName());
    user.setLastName(registerRequest.getLastName());
    user.setEmail(registerRequest.getEmail());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    user.setCreatedAt(Timestamp.from(Instant.now()));
    
    user.setRole(UserRoleEnum.USER);
    userRepository.save(user);
  }

  public AuthenticationResponse login(LoginRequest loginRequest) {
    Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
            loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authenticate);
    String token = jwtProvider.generateToken(authenticate);

    Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
    return new AuthenticationResponse(token, loginRequest.getEmail(), user.get().getRole());
  } 
}

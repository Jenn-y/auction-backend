package com.auctionapp.api.service;

import static java.util.Collections.singletonList;

import java.util.Collection;
import java.util.Optional;

import com.auctionapp.api.exceptions.UserNotFoundException;
import com.auctionapp.api.model.entities.User;
import com.auctionapp.api.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        User user = userOptional
                .orElseThrow(() -> new UserNotFoundException("No user " +
                        "Found with email :" + email));

        return new org.springframework.security.
                core.userdetails.User(user.getEmail(), user.getPassword(),
                getAuthorities("USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }
}

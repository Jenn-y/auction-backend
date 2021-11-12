package com.auctionapp.api.repository;

import java.util.Optional;
import java.util.UUID;

import com.auctionapp.api.model.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findByEmail(final String email);
	Boolean existsByEmail(final String email);
}

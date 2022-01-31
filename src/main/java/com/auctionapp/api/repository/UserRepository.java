package com.auctionapp.api.repository;

import java.util.Optional;
import java.util.UUID;

import com.auctionapp.api.model.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findByEmail(final String email);
	
	Boolean existsByEmail(final String email);

	@Modifying
    @Transactional
    @Query(value = "UPDATE user_account SET status = 'INACTIVE', first_name = '', last_name = '', phone_num = null, date_of_birth = null, gender = null WHERE id = :id", nativeQuery = true)
	void deactivateUser(@Param("id") final UUID id);
}

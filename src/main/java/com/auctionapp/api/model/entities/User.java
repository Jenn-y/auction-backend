package com.auctionapp.api.model.entities;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_account")
public class User {

	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private Timestamp createdAt;

	@Column
	private Timestamp updatedAt;

	@Column
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public User() {
	}

	public User(final UUID id,
                final String firstName,
                final String lastName,
                final String email,
                final String password,
                final Timestamp createdAt,
                final Timestamp updatedAt,
                final UserRole role) {
				
		Objects.requireNonNull(firstName, "The first name field must not be null");
		Objects.requireNonNull(lastName, "The last name field must not be null");
		Objects.requireNonNull(email, "The email address must not be null");
		Objects.requireNonNull(password, "The password must not be null");
		Objects.requireNonNull(createdAt, "The created at field must not be null");
		Objects.requireNonNull(updatedAt, "The updated at field must not be null");
		Objects.requireNonNull(role, "The role field must not be null");
		
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
		this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

	public UUID getUuid() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public UserRole getRole() {
		return role;
	}
}

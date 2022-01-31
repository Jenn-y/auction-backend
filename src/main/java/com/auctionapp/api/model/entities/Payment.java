package com.auctionapp.api.model.entities;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;

	@Column
	private Double amount;

	@Column
	private String paymentMethod;

	@Column
	private Timestamp date;

	@ManyToOne
	@JoinColumn
	private User buyer;

	@ManyToOne
	@JoinColumn
	private Auction auction;

	public Payment() {
	}

	public Payment(final UUID id,
			   final Double amount,
			   final Timestamp date,
			   final String paymentMethod,
			   final User buyer,
			   final Auction auction) {
		
		Objects.requireNonNull(amount, "The bid amount must not be null");
		Objects.requireNonNull(buyer, "The bidder must not be null");
		Objects.requireNonNull(auction, "The auction must not be null");
		Objects.requireNonNull(paymentMethod, "The payment method must not be null");

		this.id = id;
		this.amount = amount;
		this.date = date;
		this.buyer = buyer;
		this.auction = auction;
		this.paymentMethod = paymentMethod;
	}

	public UUID getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public Timestamp getDate() {
		return date;
	}

	public User getBuyer() {
		return buyer;
	}

	public Auction getAuction() {
		return auction;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
}

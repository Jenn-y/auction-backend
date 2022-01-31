package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class PaymentDto {
	private final  UUID id;
	private final Double amount;
	private final String paymentMethod;
	private Timestamp date;
	private final UserDto buyer;
	private final AuctionDto auction;

	public PaymentDto(final UUID id, 
					  final Double amount, 
					  final Timestamp date,
					  final String paymentMethod,  
					  final UserDto buyer, 
					  final AuctionDto auction) {
		this.id = id;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.date = date;
		this.buyer = buyer;
		this.auction = auction;
	}

	public UUID getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public UserDto getBuyer() {
		return buyer;
	}

	public AuctionDto getAuction() {
		return auction;
	}
}

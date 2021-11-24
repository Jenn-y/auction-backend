package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class BidDto {
	private final  UUID id;
	private final Double bidAmount;
	private Timestamp bidDate;
	private final UserDto buyer;
	private final AuctionDto auction;

	public BidDto(final UUID id,
				  final Double bidAmount,
				  final Timestamp bidDate,
				  final UserDto buyer,
				  final AuctionDto auction) {

		this.id = id;
		this.bidAmount = bidAmount;
		this.bidDate = bidDate;
		this.buyer = buyer;
		this.auction = auction;
	}

	public UUID getId() {
		return id;
	}

	public Double getBidAmount() {
		return bidAmount;
	}

	public Timestamp getBidDate() {
		return bidDate;
	}

	public UserDto getBuyer() {
		return buyer;
	}

	public AuctionDto getAuction() {
		return auction;
	}
}

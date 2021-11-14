package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class BidDto {
	private UUID id;
	private Double bidAmount;
	private Timestamp bidDate;
	private UserDto buyer;
	private AuctionDto auction;

	public BidDto() {
	}

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

	public void setId(final UUID id) {
		this.id = id;
	}

	public Double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(final Double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public Timestamp getBidDate() {
		return bidDate;
	}

	public void setBidDate(final Timestamp bidDate) {
		this.bidDate = bidDate;
	}

	public UserDto getBuyer() {
		return buyer;
	}

	public void setBuyer(final UserDto buyer) {
		this.buyer = buyer;
	}

	public AuctionDto getAuction() {
		return auction;
	}
	
	public void setAuction(final AuctionDto auction) {
		this.auction = auction;
	}
}

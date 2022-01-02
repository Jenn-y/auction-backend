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
@Table(name = "bid")
public class Bid {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;

	@Column
	private Double bidAmount;

	@Column
	private Timestamp bidDate;

	@ManyToOne
	@JoinColumn
	private User bidder;

	@ManyToOne
	@JoinColumn
	private Auction auction;

	public Bid() {
	}

	public Bid(final UUID id,
			   final Double bidAmount,
			   final Timestamp bidDate,
			   final User bidder,
			   final Auction auction) {
		
		Objects.requireNonNull(bidAmount, "The bid amount must not be null");
		Objects.requireNonNull(bidDate, "The bid date must not be null");
		Objects.requireNonNull(bidder, "The bidder must not be null");
		Objects.requireNonNull(auction, "The auction must not be null");

		this.id = id;
		this.bidAmount = bidAmount;
		this.bidDate = bidDate;
		this.bidder = bidder;
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

	public User getBidder() {
		return bidder;
	}

	public Auction getAuction() {
		return auction;
	}
}

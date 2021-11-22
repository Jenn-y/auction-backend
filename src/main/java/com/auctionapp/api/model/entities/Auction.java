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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "auction")
public class Auction {

	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;
	
	@Column
	private Timestamp startDate;

	@Column
	private Timestamp endDate;

	@Column
    private Double startPrice;

	@Column
	private Double highestBid;

	@Enumerated(EnumType.STRING)
	@Column
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column
	private Status shippingCostIncluded;

	@ManyToOne
	@JoinColumn
	private Category category;

	@ManyToOne
	@JoinColumn
	private User seller;

	@ManyToOne
	@JoinColumn
	private Item item;

	public Auction() {
	}

	public Auction(final UUID id,
                   final Timestamp startDate,
                   final Timestamp endDate,
                   final Double startPrice,
                   final Double highestBid,
                   final Status status,
                   final Status shippingCostIncluded,
                   final Category category,
                   final User seller,
                   final Item item) {
					   
        Objects.requireNonNull(startDate, "The start date field must not be null");
        Objects.requireNonNull(endDate, "The end date field must not be null");
        Objects.requireNonNull(startPrice, "The start price field must not be null");
        Objects.requireNonNull(item, "The item id field must not be null");
        Objects.requireNonNull(seller, "The seller id field must not be null");
        Objects.requireNonNull(category, "The category id field must not be null");

        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startPrice = startPrice;
        this.highestBid = highestBid;
        this.status = status;
        this.shippingCostIncluded = shippingCostIncluded;
        this.category = category;
        this.seller = seller;
        this.item = item;
    }

	public UUID getId() {
		return id;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public Double getStartPrice() {
		return startPrice;
	}

	public Double getHighestBid() {
		return highestBid;
	}

	public Status getStatus() {
		return status;
	}

	public Status getShippingCostIncluded() {
		return shippingCostIncluded;
	}

	public Category getCategory() {
		return category;
	}

	public User getSeller() {
		return seller;
	}

	public Item getItem() {
		return item;
	}
}

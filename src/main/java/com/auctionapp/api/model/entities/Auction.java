package com.auctionapp.api.model.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "auctions")
@Getter
@Setter
@NoArgsConstructor
public class Auction extends EntityWithUUID {

	@Column(name = "start_date", nullable = true)
	private Timestamp startDate;

	@Column(name = "end_date", nullable = true)
	private Timestamp endDate;

	@Column(name = "highest_bid", nullable = true)
	private Float highestBid;

	@Column(name = "adress", nullable = true)
	private String adress;

	@Column(name = "zip_code", nullable = true)
	private Integer zipCode;

	@Column(name = "phone", nullable = true)
	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = true)
	private StatusEnum status;

	@Enumerated(EnumType.STRING)
	@Column(name = "shipping_cost_included", nullable = true)
	private StatusEnum shippingCostIncluded;

	@ManyToOne
	@JoinColumn(name = "category", referencedColumnName = "uuid", nullable = true)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "seller", referencedColumnName = "uuid", nullable = true)
	private User seller;

	@ManyToOne
	@JoinColumn(name = "item", referencedColumnName = "uuid", nullable = true)
	private Item item;
}

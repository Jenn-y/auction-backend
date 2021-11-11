package com.auctionapp.api.model.entities;

import java.sql.Timestamp;
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
	private Double highestBid;

	@Column
	private String address;

	@Column
	private Integer zipCode;

	@Column
	private String phone;

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

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(final Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(final Timestamp endDate) {
		this.endDate = endDate;
	}

	public Double getHighestBid() {
		return highestBid;
	}

	public void setHighestBid(final Double highestBid) {
		this.highestBid = highestBid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(final Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(final Status status) {
		this.status = status;
	}

	public Status getShippingCostIncluded() {
		return shippingCostIncluded;
	}

	public void setShippingCostIncluded(final Status shippingCostIncluded) {
		this.shippingCostIncluded = shippingCostIncluded;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(final User seller) {
		this.seller = seller;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(final Item item) {
		this.item = item;
	}
}

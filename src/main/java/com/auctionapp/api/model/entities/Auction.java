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
@Table(name = "auctions")
public class Auction {

	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;
	
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Float getHighestBid() {
		return highestBid;
	}

	public void setHighestBid(Float highestBid) {
		this.highestBid = highestBid;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public StatusEnum getShippingCostIncluded() {
		return shippingCostIncluded;
	}

	public void setShippingCostIncluded(StatusEnum shippingCostIncluded) {
		this.shippingCostIncluded = shippingCostIncluded;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}

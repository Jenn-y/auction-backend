package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

import com.auctionapp.api.model.entities.Status;

public class AuctionDto {
	private UUID id;
	private Timestamp startDate;
	private Timestamp endDate;
	private Double highestBid;
	private String address;
	private Integer zipCode;
	private String phone;
	private Status status;
	private Status shippingCostIncluded;
	private CategoryDto category;
	private UserDto seller;
	private ItemDto item;

	public AuctionDto() {}
	
	public AuctionDto(final UUID id,
					final Timestamp startDate,
					final Timestamp endDate,
					final Double highestBid,
					final String address,
					final Integer zipCode,
					final String phone,
					final Status status,
					final Status shippingCostIncluded,
					final CategoryDto category,
					final UserDto seller,
					final ItemDto item) {

		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.highestBid = highestBid;
		this.address = address;
		this.zipCode = zipCode;
		this.phone = phone;
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

	public Double getHighestBid() {
		return highestBid;
	}

	public String getAddress() {
		return address;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public Status getStatus() {
		return status;
	}

	public Status getShippingCostIncluded() {
		return shippingCostIncluded;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public UserDto getSeller() {
		return seller;
	}

	public ItemDto getItem() {
		return item;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public void setHighestBid(Double highestBid) {
		this.highestBid = highestBid;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setShippingCostIncluded(Status shippingCostIncluded) {
		this.shippingCostIncluded = shippingCostIncluded;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public void setSeller(UserDto seller) {
		this.seller = seller;
	}

	public void setItem(ItemDto item) {
		this.item = item;
	}
}

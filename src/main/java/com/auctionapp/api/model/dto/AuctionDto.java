package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

import com.auctionapp.api.model.entities.StatusEnum;

public class AuctionDto {
	private UUID id;
	private Timestamp startDate;
	private Timestamp endDate;
	private Float highestBid;
	private String adress;
	private Integer zipCode;
	private String phone;
	private StatusEnum status;
	private StatusEnum shippingCostIncluded;
	private CategoryDto category;
	private UserDto seller;
	private ItemDto item;
	public UUID getId() {
		return id;
	}
	public void setId(UUID uuid) {
		this.id = uuid;
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
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public UserDto getSeller() {
		return seller;
	}
	public void setSeller(UserDto seller) {
		this.seller = seller;
	}
	public ItemDto getItem() {
		return item;
	}
	public void setItem(ItemDto item) {
		this.item = item;
	}
}

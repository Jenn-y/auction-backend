package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

import com.auctionapp.api.model.entities.Status;

public class AuctionDto {
	private UUID id;
	private Timestamp startDate;
	private Timestamp endDate;
	private Double startPrice;
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
                    final Double startPrice,
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
        this.startPrice = startPrice;
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

	public Double getStartPrice() {
        return startPrice;
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
}

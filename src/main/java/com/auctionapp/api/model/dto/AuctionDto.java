package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

import com.auctionapp.api.model.entities.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {
	private UUID uuid;
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
}

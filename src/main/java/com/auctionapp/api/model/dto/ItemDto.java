package com.auctionapp.api.model.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	private UUID uuid;
	private String itemNumber;
	private String name;
	private Double startPrice;
	private String color;
	private Integer size;
	private String description;
}

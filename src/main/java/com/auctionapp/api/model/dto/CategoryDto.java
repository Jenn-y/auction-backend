package com.auctionapp.api.model.dto;

import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	private UUID uuid;
	private String name;
	private CategoryDto subcategory;
	private Set<AuctionDto> itemList;

}

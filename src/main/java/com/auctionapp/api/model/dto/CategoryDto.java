package com.auctionapp.api.model.dto;

import java.util.Set;
import java.util.UUID;

public class CategoryDto {
	private UUID id;
	private String name;
	private CategoryDto subcategory;
	private Set<AuctionDto> itemList;

	public CategoryDto() {}

	public CategoryDto(final UUID id,
						final String name,
						final CategoryDto subcategory,
						final Set<AuctionDto> itemList) {

		this.id = id;
		this.name = name;
		this.subcategory = subcategory;
		this.itemList = itemList;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public CategoryDto getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(final CategoryDto subcategory) {
		this.subcategory = subcategory;
	}

	public Set<AuctionDto> getItemList() {
		return itemList;
	}

	public void setItemList(final Set<AuctionDto> itemList) {
		this.itemList = itemList;
	}
}

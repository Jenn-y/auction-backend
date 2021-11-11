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

	public String getName() {
		return name;
	}

	public CategoryDto getSubcategory() {
		return subcategory;
	}

	public Set<AuctionDto> getItemList() {
		return itemList;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubcategory(CategoryDto subcategory) {
		this.subcategory = subcategory;
	}

	public void setItemList(Set<AuctionDto> itemList) {
		this.itemList = itemList;
	}
}

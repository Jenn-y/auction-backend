package com.auctionapp.api.model.dto;

import java.util.Set;
import java.util.UUID;

public class CategoryDto {
	private UUID id;
	private String name;
	private CategoryDto subcategory;
	private Set<AuctionDto> itemList;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryDto getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(CategoryDto subcategory) {
		this.subcategory = subcategory;
	}
	public Set<AuctionDto> getItemList() {
		return itemList;
	}
	public void setItemList(Set<AuctionDto> itemList) {
		this.itemList = itemList;
	}

}

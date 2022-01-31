package com.auctionapp.api.model.dto;

import java.util.UUID;

public class CategoryDto {
	private UUID id;
	private String name;
	private CategoryDto subcategoryOf;

	public CategoryDto() {}

	public CategoryDto(final UUID id,
						final String name,
						final CategoryDto subcategoryOf) {

		this.id = id;
		this.name = name;
		this.subcategoryOf = subcategoryOf;
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

	public void setName(String name) {
		this.name = name;
	}

	public CategoryDto getSubcategoryOf() {
		return subcategoryOf;
	}

	public void setSubcategoryOf(CategoryDto subcategoryOf) {
		this.subcategoryOf = subcategoryOf;
	}
}

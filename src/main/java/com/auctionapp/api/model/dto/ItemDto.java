package com.auctionapp.api.model.dto;

import java.util.UUID;

public class ItemDto {
	private UUID id;
	private String name;
	private Double startPrice;
	private String color;
	private Integer size;
	private String description;

	public ItemDto() {}

	public ItemDto(final UUID id,
					final String itemNumber,
					final String name,
					final Double startPrice,
					final String color,
					final Integer size,
					final String description){

		this.id = id;
		this.name = name;
		this.startPrice = startPrice;
		this.color = color;
		this.size = size;
		this.description = description;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getStartPrice() {
		return startPrice;
	}

	public String getColor() {
		return color;
	}

	public Integer getSize() {
		return size;
	}

	public String getDescription() {
		return description;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setStartPrice(final Double startPrice) {
		this.startPrice = startPrice;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	public void setSize(final Integer size) {
		this.size = size;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
}

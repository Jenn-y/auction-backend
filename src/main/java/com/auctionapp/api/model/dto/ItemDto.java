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
}

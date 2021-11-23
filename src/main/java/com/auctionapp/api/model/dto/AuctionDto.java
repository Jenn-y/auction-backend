package com.auctionapp.api.model.dto;

import java.sql.Timestamp;
import java.util.UUID;

import com.auctionapp.api.model.entities.Status;

public class AuctionDto {
	private final UUID id;
	private final Timestamp startDate;
	private final Timestamp endDate;
	private final Double startPrice;
	private final Status status;
	private final CategoryDto category;
	private final UserDto seller;
	private final ItemDto item;

	public AuctionDto(final UUID id,
                    final Timestamp startDate,
                    final Timestamp endDate,
                    final Double startPrice,
                    final Status status,
                    final CategoryDto category,
                    final UserDto seller,
                    final ItemDto item) {
						
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startPrice = startPrice;
        this.status = status;
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

	public Status getStatus() {
		return status;
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

package com.auctionapp.api.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
public class Item extends EntityWithUUID {

	@Column(name = "item_number", nullable = false)
	private String itemNumber;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "start_price", nullable = true)
	private Float startPrice;

	@Column(name = "color", nullable = true)
	private String color;

	@Column(name = "size", nullable = true)
	private Integer size;

	@Column(name = "description", nullable = true)
	private String description;
}

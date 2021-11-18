package com.auctionapp.api.model.entities;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;

	@Column
	private String name;

	@Column
	private String color;

	@Column
	private Integer size;

	@Column
	private String description;

	public Item() {
	}

	public Item(final UUID id, 
				final String name, 
				final String color, 
				final Integer size, 
				final String description) {

		Objects.requireNonNull(name, "The name field must not be null");
		Objects.requireNonNull(description, "The description field must not be null");
		
		this.id = id;
		this.name = name;
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

package com.auctionapp.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.auctionapp.api.model.dto.ItemDto;

import org.junit.jupiter.api.Test;

public class ItemTest {
	private ItemDto item = new ItemDto();

	@Test
	void setName() {
		item.setName("sneakers");
		assertEquals("sneakers", item.getName());
	}

	@Test
	void setStartPrice() {
		item.setStartPrice(20.0);
		assertEquals(20, item.getStartPrice());
	}

	@Test
	void setSize() {
		item.setSize(42);
		assertEquals(42, item.getSize());
	}

	@Test
	void setColor() {
		item.setColor("white");
		assertEquals("white", item.getColor());
	}

	@Test
	void setDescription() {
		item.setDescription("fashioanble high end shoes");
		assertEquals("fashioanble high end shoes", item.getDescription());
	}
}

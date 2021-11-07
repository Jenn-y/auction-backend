package com.auctionapp.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.auctionapp.api.model.dto.CategoryDto;

import org.junit.jupiter.api.Test;

public class CategoryTest {
	private CategoryDto category = new CategoryDto();

	@Test
	void setName() {
		category.setName("shoes");
		assertEquals("shoes", category.getName());
	}

}

package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.ItemDto;
import com.auctionapp.api.model.entities.Item;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

	public static Item fromPayload(ItemDto payload) {
		Item item = new Item(
		payload.getId(),
		payload.getName(),
		payload.getStartPrice(),
		payload.getColor(),
		payload.getSize(),
		payload.getDescription()
		);
		return item;
	}

	public static ItemDto toPayload(Item item) {
		ItemDto payload = new ItemDto(
									  item.getId(),
									  item.getName(),
									  item.getStartPrice(),
									  item.getColor(),
									  item.getSize(),
									  item.getDescription()
									  );
		return payload;
	}
}

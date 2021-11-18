package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.ItemDto;
import com.auctionapp.api.model.entities.Item;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

	public static Item fromPayload(ItemDto payload) {
		Item item = new Item();
		if (payload.getId() != null) {
			item.setId(payload.getId());
		}
		item.setName(payload.getName());
		item.setStartPrice(payload.getStartPrice());
		item.setColor(payload.getColor());
		item.setSize(payload.getSize());
		item.setDescription(payload.getDescription());
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

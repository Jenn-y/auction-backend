package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.ItemDto;
import com.auctionapp.api.model.entities.Item;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

	public static Item fromPayload(ItemDto payload) {
		Item item = new Item();
		if (payload.getUuid() != null)
			item.setUuid(payload.getUuid());
		item.setName(payload.getName());
		item.setItemNumber(payload.getItemNumber());
		item.setStartPrice(payload.getStartPrice());
		item.setColor(payload.getColor());
		item.setSize(payload.getSize());
		item.setDescription(payload.getDescription());
		return item;
	}

	public static ItemDto toPayload(Item item) {
		ItemDto payload = new ItemDto();
		payload.setUuid(item.getUuid());
		payload.setName(item.getName());
		payload.setItemNumber(item.getItemNumber());
		payload.setStartPrice(item.getStartPrice());
		payload.setColor(item.getColor());
		payload.setSize(item.getSize());
		payload.setDescription(item.getDescription());
		return payload;
	}
}

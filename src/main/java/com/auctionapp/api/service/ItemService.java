package com.auctionapp.api.service;

import java.util.Optional;

import com.auctionapp.api.model.dto.ItemDto;
import com.auctionapp.api.model.entities.Item;
import com.auctionapp.api.repository.ItemRepository;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(final ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public String getDidYouMeanString(final String searchText, final Integer levenshteinDistance) {
		final Optional<Item> item = itemRepository.getAuctionsByLevenshteinDistance(searchText.toLowerCase(), levenshteinDistance);
		return item.isPresent() ? item.get().getName() : null;
	}

	public Item save(final Item payload) {
        return itemRepository.save(payload);
	}

	public static Item fromPayload(final ItemDto payload) {
		Item item = new Item(
							payload.getId(),
							payload.getName(),
							payload.getColor(),
							payload.getSize(),
							payload.getDescription()
							);
		return item;
	}

	public static ItemDto toPayload(final Item item) {
		ItemDto payload = new ItemDto(
                                      item.getId(),
                                      item.getName(),
                                      item.getColor(),
                                      item.getSize(),
                                      item.getDescription()
                                      );
		return payload;
	}
}

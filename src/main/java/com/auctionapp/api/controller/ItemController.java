package com.auctionapp.api.controller;

import com.auctionapp.api.service.ItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	private final ItemService service;

	public ItemController(final ItemService itemService) {
		this.service = itemService;
	}
	
	@GetMapping("/didYouMean")
    public ResponseEntity<String> getDidYouMeanString(@RequestParam final String searchText, 
													  @RequestParam final Integer levenshteinDistance) {
		final String result = service.getDidYouMeanString(searchText, levenshteinDistance);

		return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

package com.auctionapp.api.controller;

import java.util.Collection;

import com.auctionapp.api.model.dto.AuctionDto;
import com.auctionapp.api.service.AuctionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

	private final AuctionService service;

	public AuctionController(final AuctionService auctionService) {
		this.service = auctionService;
	}

	@GetMapping("/new_arrivals")
	public ResponseEntity<Collection<AuctionDto>> getNewArrivals() {
		Collection<AuctionDto> auctions = service.getNewArrivals();

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/last_chance")
	public ResponseEntity<Collection<AuctionDto>> getLastChance() {
		Collection<AuctionDto> auctions = service.getLastChance();

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}
}

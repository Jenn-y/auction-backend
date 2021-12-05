package com.auctionapp.api.controller;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.dto.AuctionDto;
import com.auctionapp.api.service.AuctionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

	private final AuctionService service;

	public AuctionController(final AuctionService auctionService) {
		this.service = auctionService;
	}

	@GetMapping("/new_arrivals")
	public ResponseEntity<List<AuctionDto>> getNewArrivals() {
		final List<AuctionDto> auctions = service.getNewArrivals();

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/last_chance")
	public ResponseEntity<List<AuctionDto>> getLastChance() {
		final List<AuctionDto> auctions = service.getLastChance();

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AuctionDto> get(@PathVariable final UUID id) {
		final AuctionDto result = service.getAuction(id);

		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/categories/{categoryId}")
	public ResponseEntity<List<AuctionDto>> getAuctionsByCategory(@PathVariable final UUID categoryId) {
		final List<AuctionDto> auctions = service.getAuctionsByCategory(categoryId);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/default")
	public ResponseEntity<List<AuctionDto>> getAuctionsSortDefault(@RequestParam final String[] selectedAuctions) {
		final List<AuctionDto> auctions = service.getAuctionsSortDefault(selectedAuctions);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/oldToNew")
	public ResponseEntity<List<AuctionDto>> getAuctionsOldToNew(@RequestParam final String[] selectedAuctions) {
		final List<AuctionDto> auctions = service.getAuctionsOldToNew(selectedAuctions);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/newToOld")
	public ResponseEntity<List<AuctionDto>> getAuctionsNewToOld(@RequestParam final String[] selectedAuctions) {
		final List<AuctionDto> auctions = service.getAuctionsNewToOld(selectedAuctions);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/byPriceSortDesc")
	public ResponseEntity<List<AuctionDto>> getAuctionsByPriceDesc(@RequestParam final String[] selectedAuctions) {
		final List<AuctionDto> auctions = service.getAuctionsByPriceDesc(selectedAuctions);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/byPriceSortAsc")
	public ResponseEntity<List<AuctionDto>> getAuctionsByPriceAsc(@RequestParam final String[] selectedAuctions) {
		final List<AuctionDto> auctions = service.getAuctionsByPriceAsc(selectedAuctions);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}
}

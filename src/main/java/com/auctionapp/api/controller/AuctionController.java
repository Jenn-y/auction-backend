package com.auctionapp.api.controller;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.dto.AuctionDto;
import com.auctionapp.api.model.dto.PriceCount;
import com.auctionapp.api.model.entities.Auction;
import com.auctionapp.api.model.entities.Status;
import com.auctionapp.api.model.dto.PriceInfo;
import com.auctionapp.api.service.AuctionService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/{status}/{sellerId}")
	public ResponseEntity<List<AuctionDto>> getAuctionsBySellerAndStatus(@PathVariable final Status status, 
																		 @PathVariable final UUID sellerId) {
		final List<AuctionDto> auctions = service.getAuctionsBySellerAndStatus(status, sellerId);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/{auctionId}/category/{categoryId}")
	public ResponseEntity<List<AuctionDto>> getTop3AuctionsByCategory(@PathVariable final String auctionId,
																	  @PathVariable final String categoryId) {
		final List<AuctionDto> auctions = service.getTop3AuctionsByCategory(auctionId, categoryId);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AuctionDto> get(@PathVariable final UUID id) {
		final AuctionDto result = service.getAuction(id);

		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/categories/filter")
    public Page<Auction> getFilteredAuctions(@RequestParam final String search,
												@RequestParam final Double minPrice,
												@RequestParam final Double maxPrice,
												@RequestParam final String[] categories,
												@RequestParam final Integer page) {
                                                                    
		final Page<Auction> auctions = service.getFilteredAuctions(search, minPrice, maxPrice, categories, page);

        return auctions;
    }

	@GetMapping("/countBySubcategory/{subcategoryId}")
    public ResponseEntity<Integer> getCountBySubcategory(@PathVariable final UUID subcategoryId) {
		final Integer result = service.getCountBySubcategory(subcategoryId);

		return ResponseEntity.status(HttpStatus.OK).body(result);
    }

	@GetMapping("/priceInfo")
    public ResponseEntity<PriceInfo> getPriceInfo() {
		final PriceInfo result = service.getPriceInfo();

		return ResponseEntity.status(HttpStatus.OK).body(result);
    }

	@GetMapping("/priceCount")
    public ResponseEntity<List<PriceCount>> getPriceCount(@RequestParam final String[] auctions) {
		final List<PriceCount> result = service.getPriceCount(auctions);

		return ResponseEntity.status(HttpStatus.OK).body(result);
    }

	@PostMapping("/new")
    public ResponseEntity<AuctionDto> save(@RequestBody final AuctionDto auction) {
		final AuctionDto result = service.save(auction);
		return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

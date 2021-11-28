package com.auctionapp.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.auctionapp.api.model.dto.AuctionDto;
import com.auctionapp.api.model.entities.Auction;
import com.auctionapp.api.repository.AuctionRepository;

import org.springframework.stereotype.Service;

@Service
public class AuctionService {

	private final AuctionRepository auctionRepository;

	public AuctionService(final AuctionRepository auctionRepository) {
		this.auctionRepository = auctionRepository;
	}

	public List<AuctionDto> getNewArrivals() {
		List<Auction> auctions = auctionRepository.findAllByOrderByStartDateDesc();
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getLastChance() {
		List<Auction> auctions = auctionRepository.findAllByOrderByEndDateAsc();
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public AuctionDto getAuction(final UUID id) {
		final Optional<Auction> auction = auctionRepository.findById(id);
		if (auction.isPresent()) {
			return toPayload(auction.get());
		}
		throw new RuntimeException("Auction with id " + id + " does not exist!");
	}

	public List<AuctionDto> getAuctionsByCategory(final UUID categoryId) {
		final List<Auction> auctions = auctionRepository.findAllByCategoryId(categoryId);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public static Auction fromPayload(final AuctionDto payload) {
		Auction auction = new Auction(
									payload.getId(),
									payload.getStartDate(),
									payload.getEndDate(),
									payload.getStartPrice(),
									payload.getStatus(),
									CategoryService.fromPayload(payload.getCategory()),
									UserService.fromPayload(payload.getSeller()),
									ItemService.fromPayload(payload.getItem())
									);
		return auction;
	}

	public static AuctionDto toPayload(final Auction auction) {
		AuctionDto payload = new AuctionDto(
                                            auction.getId(),
                                            auction.getStartDate(),
                                            auction.getEndDate(),
                                            auction.getStartPrice(),
                                            auction.getStatus(),
                                            CategoryService.toPayload(auction.getCategory()),
                                            UserService.toPayload(auction.getSeller()),
                                            ItemService.toPayload(auction.getItem())
                                            );
		return payload;
	}
}

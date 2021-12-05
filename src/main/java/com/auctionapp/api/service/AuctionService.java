package com.auctionapp.api.service;

import java.util.ArrayList;
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

	public List<AuctionDto> getFilteredAuctions(String[] categories, String[] subcategories) {
		final List<UUID> parentCategories = getCategories(categories);
		final List<UUID> childrenCategories = getCategories(subcategories);

		final List<Auction> auctions = auctionRepository.findAllByCategoryId(parentCategories, childrenCategories);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public Integer getCountBySubcategory(final UUID subcategoryId) {
		return auctionRepository.getCountBySubcategory(subcategoryId);
	}

	public Double getMaxPrice(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		return auctionRepository.getMaxPrice(auctionIds);
	}

	public Double getMinPrice(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		return auctionRepository.getMinPrice(auctionIds);
	}

	public Double getAveragePrice(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		return auctionRepository.getAveragePrice(auctionIds);
	}

	private List<UUID> getCategories(String[] categories) {
		List<UUID> retrievedCategories = new ArrayList<>();
		for (String category : categories) {
			retrievedCategories.add(UUID.fromString(category));
		}
		return retrievedCategories;
	}

	private List<UUID> getAuctions(final String[] auctions) {
		List<UUID> retrievedAuctionIds = new ArrayList<>();
		for (String auction : auctions) {
			retrievedAuctionIds.add(UUID.fromString(auction));
		}
		return retrievedAuctionIds;
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

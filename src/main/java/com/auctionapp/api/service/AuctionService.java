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

	public List<AuctionDto> getAuctionsByCategory(final UUID categoryId) {
		final List<Auction> auctions = auctionRepository.findAllByCategoryId(categoryId);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getAuctionsSortDefault(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		final List<Auction> auctions = auctionRepository.getAuctionsSortDefault(auctionIds);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getAuctionsOldToNew(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		final List<Auction> auctions = auctionRepository.getAuctionsOldToNew(auctionIds);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getAuctionsNewToOld(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		final List<Auction> auctions = auctionRepository.getAuctionsNewToOld(auctionIds);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getAuctionsByPriceDesc(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		final List<Auction> auctions = auctionRepository.getAuctionsByPriceDesc(auctionIds);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getAuctionsByPriceAsc(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		final List<Auction> auctions = auctionRepository.getAuctionsByPriceAsc(auctionIds);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
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

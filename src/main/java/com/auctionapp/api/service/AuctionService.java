package com.auctionapp.api.service;

import java.util.Collection;
import java.util.List;
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

	public Collection<AuctionDto> getNewArrivals() {
		List<Auction> auctions = auctionRepository.findAllByOrderByStartDateDesc();
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public Collection<AuctionDto> getLastChance() {
		List<Auction> auctions = auctionRepository.findAllByOrderByEndDateAsc();
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public static Auction fromPayload(AuctionDto payload) {
		Auction auction = new Auction();
		if (payload.getId() != null)
			auction.setId(payload.getId());
		auction.setStartDate(payload.getStartDate());
		auction.setEndDate(payload.getEndDate());
		auction.setHighestBid(payload.getHighestBid());
		auction.setAdress(payload.getAdress());
		auction.setPhone(payload.getPhone());
		auction.setZipCode(payload.getZipCode());
		auction.setStatus(payload.getStatus());
		auction.setShippingCostIncluded(payload.getShippingCostIncluded());
		auction.setItem(ItemService.fromPayload(payload.getItem()));
		auction.setCategory(CategoryService.fromPayload(payload.getCategory()));
		auction.setSeller(UserService.fromPayload(payload.getSeller()));
		return auction;
	}

	public static AuctionDto toPayload(Auction auction) {
		AuctionDto payload = new AuctionDto();
		payload.setId(auction.getId());
		payload.setStartDate(auction.getStartDate());
		payload.setEndDate(auction.getEndDate());
		payload.setHighestBid(auction.getHighestBid());
		payload.setAdress(auction.getAdress());
		payload.setPhone(auction.getPhone());
		payload.setZipCode(auction.getZipCode());
		payload.setStatus(auction.getStatus());
		payload.setShippingCostIncluded(auction.getShippingCostIncluded());
		payload.setItem(ItemService.toPayload(auction.getItem()));
		payload.setCategory(CategoryService.toPayload(auction.getCategory()));
		payload.setSeller(UserService.toPayload(auction.getSeller()));
		return payload;
	}
}

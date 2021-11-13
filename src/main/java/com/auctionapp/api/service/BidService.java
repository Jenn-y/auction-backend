package com.auctionapp.api.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.auctionapp.api.model.dto.BidDto;
import com.auctionapp.api.model.entities.Bid;
import com.auctionapp.api.repository.BidRepository;

import org.springframework.stereotype.Service;

@Service
public class BidService {

    private final BidRepository bidRepository;

    public BidService(final BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public List<BidDto> getAuctionBids(UUID auctionId) {
        List<Bid> bids = bidRepository.findAllByAuctionId(auctionId);
		return bids.stream().map(t -> toPayload(t)).collect(Collectors.toList());
    }

	public static Bid fromPayload(final BidDto payload) {
		Bid bid = new Bid(
						  payload.getId(),
						  payload.getBidAmount(),
						  payload.getBidDate(),
						  UserService.fromPayload(payload.getBuyer()),
						  AuctionService.fromPayload(payload.getAuction())
						  );
		return bid;
	}

	public static BidDto toPayload(final Bid bid) {
		BidDto payload = new BidDto(
									bid.getId(),
									bid.getBidAmount(),
									bid.getBidDate(),
									UserService.toPayload(bid.getBuyer()),
									AuctionService.toPayload(bid.getAuction())
									);
		return payload;
	}
}

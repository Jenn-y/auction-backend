package com.auctionapp.api.service;

import java.sql.Timestamp;
import java.time.Instant;
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
	private final AuctionService auctionService;

    public BidService(final BidRepository bidRepository,
					  final AuctionService auctionService) {
        this.bidRepository = bidRepository;
		this.auctionService = auctionService;
    }

    public List<BidDto> getAuctionBids(final UUID auctionId) {
        final List<Bid> bids = bidRepository.findAllByAuctionId(auctionId);
		return bids.stream().map(t -> toPayload(t)).collect(Collectors.toList());
    }

	public BidDto save(final BidDto payload) {
		payload.setBidDate(Timestamp.from(Instant.now()));
        Bid bid = fromPayload(payload);
        bid = bidRepository.save(bid);
		bid.setAuction(auctionService.update(payload.getAuction(), payload.getBidAmount()));
        return toPayload(bid);
	}

	public boolean validateBid(final BidDto bid){
		return validateBidAmount(bid.getBidAmount(), bid.getAuction().getHighestBid()) 
		        && !existsAmongBidders(bid.getBuyer().getId())
                && !isBidderEqualSeller(bid.getBuyer().getId(), bid.getAuction().getSeller().getId());
	}

	private boolean validateBidAmount(final Double currentBid, final Double highestBid) {
		return currentBid > highestBid;
	}

	private boolean existsAmongBidders(final UUID buyerId) {
		return bidRepository.existsByBuyerId(buyerId);
	}

    private boolean isBidderEqualSeller(final UUID bidderId, final UUID sellerId) {
        return bidderId == sellerId;
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

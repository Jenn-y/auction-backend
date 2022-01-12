package com.auctionapp.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.auctionapp.api.model.dto.BidDto;
import com.auctionapp.api.model.entities.Bid;
import com.auctionapp.api.repository.BidRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Bid> getAuctionBids(final UUID auctionId, final Integer page) {
		final Pageable pageable = PageRequest.of(page, 5);
        final Page<Bid> bids = bidRepository.findAllByAuctionId(auctionId, pageable);
		return bids;
    }

	public List<BidDto> getBidsByBidder(final UUID bidderId) {
        final List<Bid> bids = bidRepository.findAllByBidderId(bidderId);
		return bids.stream().map(t -> toPayload(t)).collect(Collectors.toList());
    }

	public Double getHighestBidAmount(final UUID auctionId) {
		final Optional<Bid> bidEntity = bidRepository.findTopByAuctionIdOrderByBidAmountDesc(auctionId);
		if (bidEntity.isPresent()) {
			return bidEntity.get().getBidAmount();
		}
		return auctionService.getAuction(auctionId).getStartPrice();
	}

	public Integer getNoOfBids(final UUID auctionId) {
		final List<Bid> bids = bidRepository.findAllByAuctionId(auctionId);
		return bids.size();
	}

	public BidDto save(final BidDto payload) {
        Bid bid = fromPayload(payload);
        bid = bidRepository.save(bid);
        return toPayload(bid);
	}

	public boolean validateBid(final BidDto bid){
		return validateBidAmount(bid.getBidAmount(), getHighestBidAmount(bid.getAuction().getId())) 
                && !isBidderEqualSeller(bid.getBidder().getId(), bid.getAuction().getSeller().getId());
	}

	private boolean validateBidAmount(final Double currentBid, final Double highestBid) {
		return currentBid > highestBid;
	}

    private boolean isBidderEqualSeller(final UUID bidderId, final UUID sellerId) {
        return bidderId == sellerId;
    }

	public static Bid fromPayload(final BidDto payload) {
		Bid bid = new Bid(
						  payload.getId(),
						  payload.getBidAmount(),
						  payload.getBidDate(),
						  UserService.fromPayload(payload.getBidder()),
						  AuctionService.fromPayload(payload.getAuction())
						  );
		return bid;
	}

	public static BidDto toPayload(final Bid bid) {
		BidDto payload = new BidDto(
									bid.getId(),
									bid.getBidAmount(),
									bid.getBidDate(),
									UserService.toPayload(bid.getBidder()),
									AuctionService.toPayload(bid.getAuction())
									);
		return payload;
	}
}

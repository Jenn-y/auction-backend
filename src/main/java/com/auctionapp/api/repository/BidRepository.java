package com.auctionapp.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.auctionapp.api.model.entities.Bid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, UUID> {

	Page<Bid> findAllByAuctionId(final UUID auctionId, Pageable pageable);

	Boolean existsByBidderIdAndAuctionId(final UUID bidderId, final UUID auctionId);

	Optional<Bid> findTopByAuctionIdOrderByBidAmountDesc(final UUID auctionId);

	List<Bid> findAllByBidderId(final UUID bidderId);

	List<Bid> findAllByAuctionId(final UUID auctionId);
	
}

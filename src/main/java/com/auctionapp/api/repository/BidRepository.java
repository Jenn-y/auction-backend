package com.auctionapp.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.auctionapp.api.model.entities.Bid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, UUID> {

	List<Bid> findAllByAuctionId(final UUID auctionId);

	Boolean existsByBuyerIdAndAuctionId(final UUID buyerId, final UUID auctionId);

	Optional<Bid> findByBuyerIdAndAuctionId(final UUID buyerId, final UUID auctionId);
	
}

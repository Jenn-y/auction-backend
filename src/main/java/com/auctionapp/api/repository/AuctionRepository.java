package com.auctionapp.api.repository;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.entities.Auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, UUID> {

	List<Auction> findAllByOrderByStartDateDesc();

	List<Auction> findAllByOrderByEndDateAsc();
}

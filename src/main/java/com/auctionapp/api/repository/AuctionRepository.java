package com.auctionapp.api.repository;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.entities.Auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, UUID> {

	List<Auction> findAllByOrderByStartDateDesc();

	List<Auction> findAllByOrderByEndDateAsc();

	List<Auction> findAllByCategoryId(UUID categoryId);

	@Query(value = "SELECT a.id, a.start_price, a.start_date, a.end_date, a.status, a.category_id, a.item_id, a.seller_id, i.id, i.name FROM auction a, item i WHERE a.item_id = i.id AND a.id IN :auctions ORDER BY i.name ASC", nativeQuery = true)
	List<Auction> getAuctionsSortDefault(@Param("auctions") List<UUID>  auctions);

	@Query(value = "SELECT * FROM auction WHERE id IN :auctions ORDER BY end_date ASC", nativeQuery = true)
	List<Auction> getAuctionsOldToNew(@Param("auctions") List<UUID>  auctions);

	@Query(value = "SELECT * FROM auction WHERE id IN :auctions ORDER BY start_date DESC", nativeQuery = true)
	List<Auction> getAuctionsNewToOld(@Param("auctions") List<UUID>  auctions);

	@Query(value = "SELECT * FROM auction WHERE id IN :auctions ORDER BY start_price DESC", nativeQuery = true)
	List<Auction> getAuctionsByPriceDesc(@Param("auctions") List<UUID>  auctions);

	@Query(value = "SELECT * FROM auction WHERE id IN :auctions ORDER BY start_price ASC", nativeQuery = true)
	List<Auction> getAuctionsByPriceAsc(@Param("auctions") List<UUID> auctions);
}

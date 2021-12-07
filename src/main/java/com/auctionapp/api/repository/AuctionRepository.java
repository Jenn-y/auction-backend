package com.auctionapp.api.repository;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.dto.PriceCount;
import com.auctionapp.api.model.entities.Auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, UUID> {

	List<Auction> findAllByOrderByStartDateDesc();

	List<Auction> findAllByOrderByEndDateAsc();

	@Query(value = "SELECT a.item_id, a.id, a.status, a.seller_id, a.category_id, a.start_price, a.start_date, a.end_date  FROM auction a WHERE a.category_id IN :categoryList OR a.category_id IN :subcategoryList AND (a.start_price >= :minPrice AND a.start_price <= :maxPrice)", nativeQuery = true)
	List<Auction> getFilteredAuctions(@Param("minPrice") final Double minPrice, @Param("maxPrice") final Double maxPrice, @Param("categoryList") final List<UUID> categoryList, @Param("subcategoryList") final List<UUID> subcategoryList);

	@Query(value = "SELECT COUNT(*) FROM auction where category_id = :subcategoryId", nativeQuery = true)
	Integer getCountBySubcategory(@Param("subcategoryId") final UUID subcategoryId);

	@Query(value = "SELECT MAX(start_price) FROM auction WHERE id IN :auctions", nativeQuery = true)
	Double getMaxPrice(@Param("auctions") final List<UUID> auctions);

	@Query(value = "SELECT MIN(start_price) FROM auction WHERE id IN :auctions", nativeQuery = true)
	Double getMinPrice(@Param("auctions") final List<UUID> auctions);

	@Query(value = "SELECT AVG(start_price) FROM auction WHERE id IN :auctions", nativeQuery = true)
	Double getAveragePrice(@Param("auctions") final List<UUID> auctions);

	@Query(value = "SELECT DISTINCT a1.start_price as price, (SELECT count(*) FROM auction AS a2 WHERE a1.start_price = a2.start_price AND a2.id IN :auctions) AS count FROM auction AS a1 WHERE a1.id IN :auctions ORDER BY a1.start_price ASC", nativeQuery = true)
	List<PriceCount> getPriceCount(@Param("auctions") final List<UUID> auctions);
}

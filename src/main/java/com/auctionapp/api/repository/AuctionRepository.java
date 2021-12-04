package com.auctionapp.api.repository;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.entities.Auction;
import com.auctionapp.api.model.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, UUID> {

	List<Auction> findAllByOrderByStartDateDesc();

	List<Auction> findAllByOrderByEndDateAsc();

	@Query(value = "SELECT DISTINCT a.item_id, a.id, a.seller_id, a.category_id, a.start_price, a.start_date, a.end_date  FROM auction a WHERE a.category_id IN :categoryList OR a.category_id IN :subcategoryList", nativeQuery = true)
	List<Auction> findAllByCategoryId(@Param("categoryList") List<Category> categoryList, @Param("subcategoryList") List<Category> subcategoryList);

	@Query(value = "SELECT COUNT(*) FROM auction where category_id = :subcategoryId", nativeQuery = true)
	Integer getCountBySubcategory(@Param("subcategoryId") final UUID subcategoryId);

	@Query(value = "SELECT MAX(start_price) FROM auction WHERE id IN :auctions", nativeQuery = true)
	Double getMaxPrice(@Param("auctions") String[] auctions);

	@Query(value = "SELECT MIN(start_price) FROM auction WHERE id IN :auctions", nativeQuery = true)
	Double getMinPrice(@Param("auctions") String[] auctions);

	@Query(value = "SELECT AVG(start_price) FROM auction WHERE id IN :auctions", nativeQuery = true)
	Double getAveragePrice(@Param("auctions") String[] auctions);
}

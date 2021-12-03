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

	@Query(value = "SELECT * FROM auction WHERE category_id IN :categoryList OR category_id IN :subcategoryList", nativeQuery = true)
	List<Auction> findAllByCategoryId(@Param("categoryList") List<Category> categoryList, @Param("subcategoryList") List<Category> subcategoryList);

	@Query(value = "SELECT MAX(start_price) FROM auction", nativeQuery = true)
	Double getMaxPrice();
	
	@Query(value = "SELECT MIN(start_price) FROM auction", nativeQuery = true)
	Double getMinPrice();

	@Query(value = "SELECT AVG(start_price) FROM auction", nativeQuery = true)
	Double getAveragePrice();
}

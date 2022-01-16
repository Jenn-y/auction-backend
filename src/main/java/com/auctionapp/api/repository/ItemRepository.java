package com.auctionapp.api.repository;

import java.util.Optional;
import java.util.UUID;

import com.auctionapp.api.model.entities.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

	@Query(value = "SELECT * FROM item WHERE levenshtein(LOWER(item.name), :searchText) <= :levenshteinDistance  LIMIT 1", nativeQuery = true)
	Optional<Item> getAuctionsByLevenshteinDistance(@Param("searchText") final String searchText, @Param("levenshteinDistance") final Integer levenshteinDistance);
}

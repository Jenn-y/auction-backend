package com.auctionapp.api.repository;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.dto.PriceCount;
import com.auctionapp.api.model.dto.PriceInfo;
import com.auctionapp.api.model.entities.Auction;
import com.auctionapp.api.model.entities.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, UUID>, JpaSpecificationExecutor<Auction> {

	List<Auction> findAllByStatusOrderByStartDateDesc(final Status status);

	List<Auction> findAllByStatusOrderByEndDateAsc(final Status status);

	@Query(value = "SELECT COUNT(*) FROM auction where category_id = :subcategoryId", nativeQuery = true)
	Integer getCountBySubcategory(@Param("subcategoryId") final UUID subcategoryId);

	@Query(value = "SELECT MIN(start_price) as minPrice, MAX(start_price) as maxPrice, AVG(start_price) as avgPrice FROM auction", nativeQuery = true)
	PriceInfo getPriceInfo();

	@Query(value = "SELECT DISTINCT a1.start_price as price, (SELECT count(*) FROM auction AS a2 WHERE a1.start_price = a2.start_price AND a2.id IN :auctions) AS count FROM auction AS a1 WHERE a1.id IN :auctions ORDER BY a1.start_price ASC", nativeQuery = true)
	List<PriceCount> getPriceCount(@Param("auctions") final List<UUID> auctions);

	List<Auction> findAllBySellerIdAndStatus(final UUID sellerId, final Status active);

	List<Auction> findTop3ByCategoryIdAndIdNotAndStatus(final UUID categoryId, final UUID id, final Status status);
}

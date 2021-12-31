package com.auctionapp.api.repository;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.dto.PriceCount;
import com.auctionapp.api.model.dto.PriceInfo;
import com.auctionapp.api.model.entities.Auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, UUID>, JpaSpecificationExecutor<Auction> {

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
	
	@Query(value = "SELECT COUNT(*) FROM auction where category_id = :subcategoryId", nativeQuery = true)
	Integer getCountBySubcategory(@Param("subcategoryId") final UUID subcategoryId);

	@Query(value = "SELECT MIN(start_price) as minPrice, MAX(start_price) as maxPrice, AVG(start_price) as avgPrice FROM auction", nativeQuery = true)
	PriceInfo getPriceInfo();

	@Query(value = "SELECT DISTINCT a1.start_price as price, (SELECT count(*) FROM auction AS a2 WHERE a1.start_price = a2.start_price AND a2.id IN :auctions) AS count FROM auction AS a1 WHERE a1.id IN :auctions ORDER BY a1.start_price ASC", nativeQuery = true)
	List<PriceCount> getPriceCount(@Param("auctions") final List<UUID> auctions);
}

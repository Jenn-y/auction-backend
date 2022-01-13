package com.auctionapp.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.auctionapp.api.model.dto.AuctionDto;
import com.auctionapp.api.model.dto.PriceCount;
import com.auctionapp.api.model.dto.PriceInfo;
import com.auctionapp.api.model.entities.Auction;
import com.auctionapp.api.model.entities.Category;
import com.auctionapp.api.model.entities.Status;
import com.auctionapp.api.repository.AuctionRepository;
import com.auctionapp.api.repository.specification.GenericSpecificationsBuilder;
import com.auctionapp.api.repository.specification.SortingCriteria;
import com.auctionapp.api.repository.specification.SpecificationFactory;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

	private final AuctionRepository auctionRepository;
	private final CategoryService categoryService;
	private SpecificationFactory<Auction> auctionSpecificationFactory;

	public AuctionService(final AuctionRepository auctionRepository,
						  final CategoryService categoryService,
						  final SpecificationFactory<Auction> aFactory) {
		this.auctionRepository = auctionRepository;
		this.categoryService = categoryService;
		this.auctionSpecificationFactory = aFactory;
	}

	public List<AuctionDto> getNewArrivals() {
		List<Auction> auctions = auctionRepository.findAllByOrderByStartDateDesc();
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getLastChance() {
		List<Auction> auctions = auctionRepository.findAllByOrderByEndDateAsc();
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getAuctionsBySellerAndStatus(final Status status, final UUID sellerId) {
		List<Auction> auctions = auctionRepository.findAllBySellerIdAndStatus(sellerId, status);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getTop3AuctionsByCategory(final String auctionId, final String categoryId) {
		List<Auction> auctions = auctionRepository.findTop3ByCategoryIdAndIdNot(UUID.fromString(categoryId), UUID.fromString(auctionId));
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public AuctionDto getAuction(final UUID id) {
		final Optional<Auction> auction = auctionRepository.findById(id);
		if (auction.isPresent()) {
			return toPayload(auction.get());
		}
		throw new RuntimeException("Auction with id " + id + " does not exist!");
	}

	public Page<Auction> getFilteredAuctions(final String search, 
												final Double minPrice, 
												final Double maxPrice, 
												final String[] categories, 
												final String sortType,
												final Integer page) {

		GenericSpecificationsBuilder<Auction> builder = new GenericSpecificationsBuilder<>();

		if (Objects.nonNull(search)) {
			builder.with(auctionSpecificationFactory.filterBySearch("name", search));
		}
		
		if (Objects.nonNull(minPrice)) {
			builder.with(auctionSpecificationFactory.filterByMinPrice("startPrice", minPrice - 1));
		}

		if (Objects.nonNull(maxPrice)) {
			builder.with(auctionSpecificationFactory.filterByMaxPrice("startPrice", maxPrice + 1));
		}

		if (categories.length > 0) {
			final List<Category> selectedCategories = getCategories(categories);
			builder.with(auctionSpecificationFactory.filterBySelectedCategories("category", selectedCategories));
		}  

		final Pageable pageable = PageRequest.of(page, 6);
		final Page<Auction> auctions = auctionRepository.findAll(builder.build(), pageable);
		return auctions;
	}
	
	private SortingCriteria getSortOptions(String sortType) {
		switch (sortType) {
			case "newToOld":
				return new SortingCriteria(Sort.Direction.DESC, "startDate");
			case "oldToNew":
				return new SortingCriteria(Sort.Direction.ASC, "endDate");
			case "lowestPrice":
				return new SortingCriteria(Sort.Direction.ASC, "startPrice");
			case "highestPrice":
				return new SortingCriteria(Sort.Direction.DESC, "startPrice");
			default:
				return new SortingCriteria(Sort.Direction.DESC, "startDate");
		}
	}

	public Integer getCountBySubcategory(final UUID subcategoryId) {
		return auctionRepository.getCountBySubcategory(subcategoryId);
	}

	public PriceInfo getPriceInfo() {
		return auctionRepository.getPriceInfo();
	}

	private List<Category> getCategories(final String[] categories) {
		List<Category> retrievedCategories = new ArrayList<>();
		for (String category : categories) {
			Category cat = categoryService.getCategory(UUID.fromString(category));
			retrievedCategories.add(cat);
		}
		return retrievedCategories;
	}

	private List<UUID> getAuctions(final String[] auctions) {
		List<UUID> retrievedAuctionIds = new ArrayList<>();
		for (String auction : auctions) {
			retrievedAuctionIds.add(UUID.fromString(auction));
		}
		return retrievedAuctionIds;
	}

	public List<PriceCount> getPriceCount(final String[] selectedAuctions) {
		final List<UUID> auctionIds = getAuctions(selectedAuctions);
		return auctionRepository.getPriceCount(auctionIds);
	}

	public AuctionDto save(final AuctionDto payload) {
        Auction auction = fromPayload(payload);
		auction.setStatus(Status.ACTIVE);
        auction = auctionRepository.save(auction);
        return toPayload(auction);
	}

	public static Auction fromPayload(final AuctionDto payload) {
		Auction auction = new Auction(
									payload.getId(),
									payload.getStartDate(),
									payload.getEndDate(),
									payload.getStartPrice(),
									payload.getStatus(),
									CategoryService.fromPayload(payload.getCategory()),
									UserService.fromPayload(payload.getSeller()),
									ItemService.fromPayload(payload.getItem())
									);
		return auction;
	}

	public static AuctionDto toPayload(final Auction auction) {
		AuctionDto payload = new AuctionDto(
                                            auction.getId(),
                                            auction.getStartDate(),
                                            auction.getEndDate(),
                                            auction.getStartPrice(),
                                            auction.getStatus(),
                                            CategoryService.toPayload(auction.getCategory()),
                                            UserService.toPayload(auction.getSeller()),
                                            ItemService.toPayload(auction.getItem())
                                            );
		return payload;
	}
}

package com.auctionapp.api.repository.specification;

import org.springframework.data.domain.Sort;

public class SortingCriteria {
	private final Sort.Direction direction;
	private final String sortBy;

	public SortingCriteria(final Sort.Direction direction, final String sortBy) {
		this.direction = direction;
		this.sortBy = sortBy;
	}

	public Sort.Direction getDirection() {
		return direction;
	}

	public String getSortBy() {
		return sortBy;
	}
	
}

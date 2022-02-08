package com.auctionapp.api.repository.specification;

import java.util.List;

public class SearchCriteria {
  
	private final String key;
	private final SearchOperation searchOperation;
	private final boolean isOrOperation;
	private final List<Object> arguments;

	public SearchCriteria(final String key, 
						  final SearchOperation searchOperation, 
						  final boolean isOrOperation, 
						  final List<Object> arguments) {
							  
		this.key = key;
		this.searchOperation = searchOperation;
		this.isOrOperation = isOrOperation;
		this.arguments = arguments;
	}

	public String getKey() {
		return key;
	}

	public SearchOperation getSearchOperation() {
		return searchOperation;
	}

	public boolean isOrOperation() {
		return isOrOperation;
	}

	public List<Object> getArguments() {
		return arguments;
	}
 }
 

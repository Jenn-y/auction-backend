package com.auctionapp.api.repository.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification<T> implements Specification<T> {
   
	private SearchCriteria searchCriteria;
	
	public GenericSpecification(final SearchCriteria searchCriteria){
	   super();
	   this.searchCriteria = searchCriteria;
	}
	
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
		List<Object> arguments = searchCriteria.getArguments();
		Object arg = arguments.get(0);
		Join<Object, Object> item = root.join("item");

		switch (searchCriteria.getSearchOperation()) {
			case LESS_THAN:
				return criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), (Comparable) arg);
			case GREATER_THAN:
				return criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()), (Comparable) arg);
			case IN:
				return root.get(searchCriteria.getKey()).in(arguments);
			case LIKE:
				final String pattern = "%" + arg + "%";
				return criteriaBuilder.like(item.get("name"), pattern);
	   }

		return criteriaBuilder.equal(root.get(searchCriteria.getKey()), arg);
	}
 }

package com.auctionapp.api.repository.specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.auctionapp.api.model.entities.Category;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecificationFactory<T> {
	public Specification<T> filterBySelectedCategories(String key, List<Category> selectedCategories) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.IN, new ArrayList<Object>(selectedCategories)).build();
    }

	public Specification<T> filterByMaxPrice(String key, Double arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.LESS_THAN, Collections.singletonList(arg)).build();
    }

	public Specification<T> filterByMinPrice(String key, Double arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchOperation.GREATER_THAN, Collections.singletonList(arg)).build();
    }
}

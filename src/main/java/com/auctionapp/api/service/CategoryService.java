package com.auctionapp.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.auctionapp.api.model.dto.CategoryDto;
import com.auctionapp.api.model.entities.Category;
import com.auctionapp.api.repository.CategoryRepository;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(final CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<CategoryDto> getLimitedCategories() {
		List<Category> categories = categoryRepository.findTop6BySubcategoryOfIsNullOrderByNameAsc();
		return categories.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<CategoryDto> getAllSubcategories(final UUID categoryId) {
		final Category category = getCategory(categoryId);
		List<Category> subcategories = categoryRepository.findAllBySubcategoryOf(category);
		return subcategories.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public Category getCategory(final UUID categoryId) {
		final Optional<Category> category = categoryRepository.findById(categoryId);
		if (category.isPresent()) {
			return category.get();
		}
		throw new RuntimeException("Category with id " + categoryId + " does not exist!");
	}

	public static Category fromPayload(final CategoryDto payload) {
		Category category = new Category();
		if (payload.getId() != null) {
			category.setId(payload.getId());
		}
		category.setName(payload.getName());
		if (payload.getSubcategoryOf() != null) {
			category.setSubcategoryOf(CategoryService.fromPayload(payload.getSubcategoryOf()));
		}
		category.setAuctionSet(payload.getAuctionSet()
									.stream()
									.map(t -> AuctionService.fromPayload(t))
									.collect(Collectors.toSet()));
		return category;
	}

	public static CategoryDto toPayload(final Category category) {
		CategoryDto payload = new CategoryDto();
		payload.setId(category.getId());
		payload.setName(category.getName());
		if (category.getSubcategoryOf() != null) {
			payload.setSubcategoryOf(CategoryService.parentToPayload(category.getSubcategoryOf()));
		}
		return payload;
	}

	public static CategoryDto parentToPayload(final Category category) {
		CategoryDto payload = new CategoryDto();
		payload.setId(category.getId());
		payload.setName(category.getName());
		return payload;
	}
}

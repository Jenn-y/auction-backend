package com.auctionapp.api.repository;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

	List<Category> findTop6BySubcategoryOfIsNullOrderByNameAsc();

	List<Category> findAllBySubcategoryOfIsNullOrderByNameAsc();

	List<Category> findAllBySubcategoryOf(final Category subcategoryOf);

}

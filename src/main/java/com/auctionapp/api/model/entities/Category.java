package com.auctionapp.api.model.entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "subcategory_of", referencedColumnName = "id")
	private Category subcategoryOf;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<Auction> auctionSet;

	public Category() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Category getSubcategoryOf() {
		return subcategoryOf;
	}

	public void setSubcategoryOf(final Category subcategory) {
		this.subcategoryOf = subcategory;
	}

	public Set<Auction> getAuctionSet() {
		return auctionSet;
	}

	public void setAuctionSet(final Set<Auction> auctionSet) {
		this.auctionSet = auctionSet;
	}
}

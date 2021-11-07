package com.auctionapp.api.model.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category extends EntityWithUUID {

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "subcategory", referencedColumnName = "uuid", nullable = true)
	private Category subcategory;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<Auction> itemList;
}

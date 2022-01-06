package com.auctionapp.api.repository;

import java.util.UUID;

import com.auctionapp.api.model.entities.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

}

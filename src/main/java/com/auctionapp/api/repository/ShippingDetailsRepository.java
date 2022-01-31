package com.auctionapp.api.repository;

import java.util.UUID;

import com.auctionapp.api.model.entities.ShippingDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingDetailsRepository extends JpaRepository<ShippingDetails, UUID> {

}

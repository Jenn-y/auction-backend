package com.auctionapp.api.repository;

import java.util.UUID;

import com.auctionapp.api.model.entities.PaymentDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, UUID> {

}

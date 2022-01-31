package com.auctionapp.api.repository;

import java.util.UUID;

import com.auctionapp.api.model.entities.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

}

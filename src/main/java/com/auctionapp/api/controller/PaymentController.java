package com.auctionapp.api.controller;

import com.auctionapp.api.model.dto.PaymentDto;
import com.auctionapp.api.service.PaymentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	private final PaymentService service;

	public PaymentController(final PaymentService paymentService) {
		this.service = paymentService;
	}

	@PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody final PaymentDto payment){
		final String result = service.processPayment(payment);
		return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.PaymentDetailsDto;
import com.auctionapp.api.model.entities.PaymentDetails;

import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsService {

	public static PaymentDetails fromPayload(final PaymentDetailsDto payload) {
		PaymentDetails paymentDetails = new PaymentDetails(
							payload.getId(),
							payload.getPaypal(),
							payload.getCardName(),
							payload.getCardNumber(),
							payload.getExpirationDate(),
							payload.getVerificationCode()
							);
		return paymentDetails;
	}

	public static PaymentDetailsDto toPayload(final PaymentDetails paymentDetails) {
		PaymentDetailsDto payload = new PaymentDetailsDto(
                                      paymentDetails.getId(),
                                      paymentDetails.getPaypal(),
									  paymentDetails.getCardName(),
									  paymentDetails.getCardNumber(),
									  paymentDetails.getExpirationDate(),
									  paymentDetails.getVerificationCode()
                                      );
		return payload;
	}
}

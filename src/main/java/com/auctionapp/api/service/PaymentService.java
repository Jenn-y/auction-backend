package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.PaymentDto;
import com.auctionapp.api.model.entities.Payment;
import com.auctionapp.api.repository.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Value("${stripe.apiKey}")
    private String apiKey;
	
	private final PaymentRepository paymentRepository;
	private final AuctionService auctionService;
	
	public PaymentService(final PaymentRepository paymentRepository,
						  final AuctionService auctionService) {
		this.paymentRepository = paymentRepository;
		this.auctionService = auctionService;
	}

	public String processPayment(final PaymentDto payload) {
		Payment payment = fromPayload(payload);
        try {
            PaymentIntent paymentIntent = createAndConfirmPaymentIntent(payment.getPaymentMethod(), payment.getAmount().longValue());
            paymentRepository.save(payment);
			auctionService.updateSoldStatus(payment.getAuction());
            return paymentIntent.getStatus();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private PaymentIntent createAndConfirmPaymentIntent(final String paymentMethod, final Long price) throws StripeException {
        Stripe.apiKey = apiKey;
        PaymentIntentCreateParams paymentIntentCreateParams = PaymentIntentCreateParams.builder()
                .setAmount(convertToCents(price))
                .setCurrency("USD")
                .setPaymentMethod(paymentMethod)
                .setConfirm(true)
                .build();
        return PaymentIntent.create(paymentIntentCreateParams);
    }

    private Long convertToCents(final Long price) {
        return price * 100L;
    }

	public static Payment fromPayload(final PaymentDto payload) {
		Payment payment = new Payment(
						  payload.getId(),
						  payload.getAmount(),
						  payload.getDate(),
						  payload.getPaymentMethod(),
						  UserService.fromPayload(payload.getBuyer()),
						  AuctionService.fromPayload(payload.getAuction())
						  );
		return payment;
	}

	public static PaymentDto toPayload(final Payment payment) {
		PaymentDto payload = new PaymentDto(
									payment.getId(),
									payment.getAmount(),
									payment.getDate(),
									payment.getPaymentMethod(),
									UserService.toPayload(payment.getBuyer()),
									AuctionService.toPayload(payment.getAuction())
									);
		return payload;
	}
}

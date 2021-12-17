package com.auctionapp.api.model.dto;

import java.sql.Date;
import java.util.UUID;

public class PaymentDetailsDto {
    private final UUID id;
    private final Boolean paypal;
    private final String cardName;
    private final String cardNumber;
    private final Date expirationDate;
    private final String verificationCode;

    public PaymentDetailsDto(final UUID id, 
                          final Boolean paypal, 
                          final String cardName, 
                          final String cardNumber, 
                          final Date expirationDate,
                          final String verificationCode) {
        this.id = id;
        this.paypal = paypal;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.verificationCode = verificationCode;
    }

    public UUID getId() {
        return id;
    }

    public Boolean getPaypal() {
        return paypal;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
}

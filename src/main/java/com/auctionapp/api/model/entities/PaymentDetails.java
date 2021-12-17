package com.auctionapp.api.model.entities;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "pg-uuid")
    private UUID id;

    @Column
    private Boolean paypal;

    @Column
    private String cardName;

    @Column
    private String cardNumber;

    @Column
    private Date expirationDate;

    @Column
    private String verificationCode;

    public PaymentDetails() {
    }

    public PaymentDetails(final UUID id, 
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

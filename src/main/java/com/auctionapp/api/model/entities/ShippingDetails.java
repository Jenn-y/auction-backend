package com.auctionapp.api.model.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "shipping_details")
public class ShippingDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "pg-uuid")
    private UUID id;

    @Column
    private String streetName;

    @Column
    private String city;

    @Column
    private Integer zipCode;

    @Column
    private String state;

    @Column
    private String country;

    public ShippingDetails() {
    }

    public ShippingDetails(final UUID id, 
                           final String streetName, 
                           final String city, 
                           final Integer zipCode, 
                           final String state, 
                           final String country) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}

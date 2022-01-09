package com.auctionapp.api.model.dto;

import java.util.UUID;

public class ShippingDetailsDto {
    private final UUID id;
    private final String streetName;
    private final String city;
    private final String zipCode;
    private final String state;
    private final String country;

    public ShippingDetailsDto(final UUID id, 
                            final String streetName, 
                            final String city, 
                            final String zipCode, 
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

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}

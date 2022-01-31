package com.auctionapp.api.service;

import com.auctionapp.api.model.dto.ShippingDetailsDto;
import com.auctionapp.api.model.entities.ShippingDetails;

import org.springframework.stereotype.Service;

@Service
public class ShippingDetailsService {

	public static ShippingDetails fromPayload(final ShippingDetailsDto payload) {
		if (payload == null) {
			return null;
		}
		ShippingDetails shippingDetails = new ShippingDetails(
							payload.getId(),
							payload.getStreetName(),
							payload.getCity(),
							payload.getZipCode(),
							payload.getState(),
							payload.getCountry()
							);
		return shippingDetails;
	}

	public static ShippingDetailsDto toPayload(final ShippingDetails shippingDetails) {
		if (shippingDetails == null) {
			return null;
		}
		ShippingDetailsDto payload = new ShippingDetailsDto(
                                      shippingDetails.getId(),
                                      shippingDetails.getStreetName(),
									  shippingDetails.getCity(),
									  shippingDetails.getZipCode(),
									  shippingDetails.getState(),
									  shippingDetails.getCountry()
                                      );
		return payload;
	}
}

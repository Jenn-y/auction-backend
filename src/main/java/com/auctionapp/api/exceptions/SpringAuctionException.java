package com.auctionapp.api.exceptions;

public class SpringAuctionException extends RuntimeException {
	public SpringAuctionException (String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringAuctionException (String exMessage) {
        super(exMessage);
    }
}

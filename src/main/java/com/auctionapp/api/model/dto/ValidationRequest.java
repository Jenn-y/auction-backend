package com.auctionapp.api.model.dto;

public class ValidationRequest {
	private String message;
	private boolean status;
	
	public ValidationRequest(final String message, final boolean status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}

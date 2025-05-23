package com.app.dto;

public class OrderPlaceDto {

	private int userId;
	private int addressId;
	private String paymentMode;

	public OrderPlaceDto() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public OrderPlaceDto(int userId, int addressId, String paymentMode) {
		super();
		this.userId = userId;
		this.addressId = addressId;
		this.paymentMode = paymentMode;
	}
}
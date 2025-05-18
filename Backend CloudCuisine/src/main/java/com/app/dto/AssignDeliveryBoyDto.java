package com.app.dto;


public class AssignDeliveryBoyDto {

	private int orderId;
	private int userId;

	public AssignDeliveryBoyDto() {
		// TODO Auto-generated constructor stub
	}
	
	public AssignDeliveryBoyDto(int orderId, int userId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
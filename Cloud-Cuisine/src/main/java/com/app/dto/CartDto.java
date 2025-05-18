package com.app.dto;

public class CartDto 
{
	private int menuId;
	private int userId;
	private int quantity;
	
	public CartDto() {}
	public CartDto(int menuId, int userId, int quantity) {
		super();
		this.menuId = menuId;
		this.userId = userId;
		this.quantity = quantity;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
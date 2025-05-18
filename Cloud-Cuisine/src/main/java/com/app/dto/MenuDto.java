package com.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class MenuDto {
	private double price;

	private String description;

	private Byte status;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public MenuDto(double price, String description, Byte status) {
		super();
		this.price = price;
		this.description = description;
		this.status = status;
	}

	public MenuDto() {
	}
}
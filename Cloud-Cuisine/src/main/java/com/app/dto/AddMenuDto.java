package com.app.dto;

import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Menu;
import com.app.entities.Type;

public class AddMenuDto {
	
	private String menuName;
	private double price;
	private String description;
	private MultipartFile imageName;
	private int restaurent;
	private int catagory;
	private Byte status;
	private String type;

	public static Menu toEntity(AddMenuDto dto) {
		Menu entity = new Menu();
		entity.setProductName(dto.menuName);
		entity.setDescription(dto.description);
		entity.setPrice(dto.price);
		entity.setStatus((byte) 1);
		entity.setType(Type.valueOf(dto.type));
		return entity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

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

	public MultipartFile getImageName() {
		return imageName;
	}

	public void setImageName(MultipartFile imageName) {
		this.imageName = imageName;
	}

	public int getRestaurent() {
		return restaurent;
	}

	public void setRestaurent(int restaurent) {
		this.restaurent = restaurent;
	}

	public int getCatagory() {
		return catagory;
	}

	public void setCatagory(int catagory) {
		this.catagory = catagory;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public AddMenuDto() {
	}

	public AddMenuDto(String menuName, double price, String description, MultipartFile imageName, int restaurent,
			int catagory, Byte status, String type) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.imageName = imageName;
		this.restaurent = restaurent;
		this.catagory = catagory;
		this.status = status;
		this.type = type;
	}
	
}
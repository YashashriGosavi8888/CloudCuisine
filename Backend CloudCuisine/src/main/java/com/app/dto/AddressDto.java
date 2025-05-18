package com.app.dto;

public class AddressDto {

	private int id;
	private String state;
	private String city;
	private String contact_no;
	private String add_line_1;
	private String add_line_2;
	private int pincode;
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getAdd_line_1() {
		return add_line_1;
	}

	public void setAdd_line_1(String add_line_1) {
		this.add_line_1 = add_line_1;
	}

	public String getAdd_line_2() {
		return add_line_2;
	}

	public void setAdd_line_2(String add_line_2) {
		this.add_line_2 = add_line_2;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public AddressDto() {
	}

	public AddressDto(int id, String state, String city, String contact_no, String add_line_1, String add_line_2,
			int pincode, int user_id) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
		this.contact_no = contact_no;
		this.add_line_1 = add_line_1;
		this.add_line_2 = add_line_2;
		this.pincode = pincode;
		this.user_id = user_id;
	}
}

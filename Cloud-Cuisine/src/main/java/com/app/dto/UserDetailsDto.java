package com.app.dto;

public class UserDetailsDto {

	private String contact_no;
	private String email;
	private String name;
	private String password;

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetailsDto(String contact_no, String email, String name, String password) {
		super();
		this.contact_no = contact_no;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public UserDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
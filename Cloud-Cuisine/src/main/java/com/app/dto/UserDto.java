package com.app.dto;

public class UserDto {

	private int id;
	private String contact_no;
	private String email;
	private String name;
	private String password;
	private String role;
//	private Byte isActive;
	private String isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	/*
	 * public Byte getisActive() { return isActive; }
	 * 
	 * public void setStatus(Byte isActive) { this.isActive = isActive; }
	 */
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public UserDto(int id, String contact_no, String email, String name, String password, String role,String isActive) {
		super();
		this.id = id;
		this.contact_no = contact_no;
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}

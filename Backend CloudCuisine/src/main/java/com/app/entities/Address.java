package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "add_line_1", length = 50)
	private String line1;

	@Column(name = "add_line_2", length = 50)
	private String line2;

	@Column(name = "contact_no", length = 15)
	private String contactNo;

	@Column(name = "pincode")
	private int pincode;

	@Column(length = 20, name = "city")
	private String city;

	@Column(length = 20, name = "state")
	private String state;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User selectedUser;

	public Address() {
	}

	public Address(Integer id, String line1, String line2, String contactNo, int pincode, String city, String state,
			User selectedUser) {
		super();
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.contactNo = contactNo;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.selectedUser = selectedUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
}
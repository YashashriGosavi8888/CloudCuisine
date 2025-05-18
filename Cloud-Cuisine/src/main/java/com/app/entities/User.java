package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50, name = "name")
	private String name;
	
	@Column(unique = true, length = 30, name = "email")
	private String email;
	
	@Column(name = "contact_no", length = 13)
	private String contact;
	 
	@Column(name = "password")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, name = "role")
	private Role role;
	
	/*
	 * @Column(name = "is_active",nullable = false) private byte isActive = 1;
	 */
	
	@Column(name = "is_active",nullable = false) 
	private String isActive ;
	
	
	public User() {
	}

	public User(Integer id, String name, String email, String contact, String password, Role role, String isActive) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	/*
	 * public byte getisActive() { return isActive; }
	 * 
	 * public void setStatus(byte isActive) { this.isActive = isActive; }
	 */
	  
}
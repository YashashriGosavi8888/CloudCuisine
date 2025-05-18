package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id",nullable = false)
	private Menu selectedMenu;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false)
	private User currentUser;
	
	public Cart(int quantity, Menu selectedMenu, User currentUser) {
		super();
		this.quantity = quantity;
		this.selectedMenu = selectedMenu;
		this.currentUser = currentUser;
	}

	public Cart(Integer id, int quantity, Menu selectedMenu, User currentUser) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.selectedMenu = selectedMenu;
		this.currentUser = currentUser;
	}

	public Cart() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Menu getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(Menu selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}

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
@Table(name = "order_details")

public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "total_ammount")
	private double total;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "foodorder_id", nullable = false)
	private FoodOrder currentOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id", nullable = false)
	private Menu selectedProduct;

	public OrderDetails(int quantity, double total, FoodOrder currentOrder, Menu selectedProduct) {
		super();
		this.quantity = quantity;
		this.total = total;
		this.currentOrder = currentOrder;
		this.selectedProduct = selectedProduct;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public FoodOrder getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(FoodOrder currentOrder) {
		this.currentOrder = currentOrder;
	}

	public Menu getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Menu selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
}
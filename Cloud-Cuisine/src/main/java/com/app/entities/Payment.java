package com.app.entities;

import java.time.LocalDateTime; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "payment")
public class Payment  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ammount")
	private double ammount;
	
	@Enumerated(EnumType.STRING)
	
	@Column(name = "payment_status", length=25)
	private PaymentStatus paymentStatus;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="order_dateTime")
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_mode", length=20)
	private PaymentModes payment_mode;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "foodorder_id",nullable = false)
	private FoodOrder currentOrder;

	public Payment(double ammount, PaymentStatus paymentStatus, LocalDateTime orderDate, PaymentModes payment_mode,
			FoodOrder currentOrder) {
		super();
		this.ammount = ammount;
		this.paymentStatus = paymentStatus;
		this.orderDate = orderDate;
		this.payment_mode = payment_mode;
		this.currentOrder = currentOrder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public PaymentModes getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(PaymentModes payment_mode) {
		this.payment_mode = payment_mode;
	}

	public FoodOrder getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(FoodOrder currentOrder) {
		this.currentOrder = currentOrder;
	}

	public Payment(Integer id, double ammount, PaymentStatus paymentStatus, LocalDateTime orderDate,
			PaymentModes payment_mode, FoodOrder currentOrder) {
		super();
		this.id = id;
		this.ammount = ammount;
		this.paymentStatus = paymentStatus;
		this.orderDate = orderDate;
		this.payment_mode = payment_mode;
		this.currentOrder = currentOrder;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

}

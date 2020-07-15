package com.order.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {
	
	@Id
	@Column(name="order_id", nullable = false, updatable = false)
	private Long orderId = System.nanoTime();
	
	@NotNull(message = "Please provide customerName")
	@Column(name="cutomer_name")
	private String customerName;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	@Column(name="shipping_address")
	private String shippingAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@Column(name="order_items")
	@NotNull(message = "Order Items Should not be empty")
	private List<Item> orderItems;
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	public Orders() {
		
	}

	public Orders(Long orderId, String customerName, LocalDate orderDate, String shippingAddress, List<Item> orderItems,
			Double totalAmount) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.orderItems = orderItems;
		this.totalAmount = totalAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Item> orderItems) {
		this.orderItems = orderItems;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}

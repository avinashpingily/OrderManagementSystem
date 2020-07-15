package com.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ORDERITEM")
public class Item {
	
	@Id
	@Column(name="product_code")
	private Long productCode;
	
	@NotNull(message = "Please provide productName")
	@Column(name="product_name")
	private String productName;
	
	@NotNull(message = "Please provide quantity")
	@Column(name="quantity")
	private int quantity;

	public Item() {

	}

	public Item(Long id, Long productCode, String productName, int quantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
	}

	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}

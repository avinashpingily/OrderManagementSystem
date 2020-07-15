package com.item.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Item {
	
	@Id
	@Column(name="product_code")
	private Long productCode;
	
	@Column(name="product_name")
	@NotNull(message = "Please provide productName")
	private String productName;
	
	@Column(name="quantity")
	@NotNull(message = "Please provide quantity")
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

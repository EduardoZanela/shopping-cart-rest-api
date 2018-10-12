package com.eduardozanela.commerce.commerce.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request implements Serializable{
	
	private static final long serialVersionUID = -6937699880995497924L;
	@JsonProperty("product_id")
	private String productId;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}

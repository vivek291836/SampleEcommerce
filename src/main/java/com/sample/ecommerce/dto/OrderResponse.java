package com.sample.ecommerce.dto;

import java.util.List;

import com.sample.ecommerce.model.Order;

public class OrderResponse {
	
	private String status;
	private String message;
	private List<Order> orders;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}

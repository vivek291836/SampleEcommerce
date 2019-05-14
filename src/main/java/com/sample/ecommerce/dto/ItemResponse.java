package com.sample.ecommerce.dto;

import java.util.List;

import com.sample.ecommerce.model.Item;

public class ItemResponse {
	
	private String status;
	private String message;
	private List<Item> items;
	
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
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}

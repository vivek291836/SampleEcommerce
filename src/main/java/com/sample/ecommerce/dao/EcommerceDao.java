package com.sample.ecommerce.dao;

import java.util.List;

import com.sample.ecommerce.model.Item;
import com.sample.ecommerce.model.Order;

public interface EcommerceDao {
	
	public String addItem (Item item);
	
	public String deleteItem (String itemName);
	
	public String updateItem (String itemName, Item item);
	
	public List<Item> getItems ();
		
	public String placeOrders (List<Order> orders);
	
	public List<Order> getOrders ();
	
	//Util methods
	
	public Item getItem(String itemName);

}

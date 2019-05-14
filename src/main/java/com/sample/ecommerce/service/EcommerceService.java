package com.sample.ecommerce.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.ecommerce.constant.Constants;
import com.sample.ecommerce.dao.EcommerceDao;
import com.sample.ecommerce.dto.ItemResponse;
import com.sample.ecommerce.dto.OrderResponse;
import com.sample.ecommerce.model.Item;
import com.sample.ecommerce.model.Order;

@Service
@Transactional
public class EcommerceService {
	
	@Autowired
	private EcommerceDao ecommerceDao;
	
	public ItemResponse addItem(Item item) {
		ItemResponse response = new ItemResponse();
		boolean isItemAlreadyPresent = checkIfItemAlreadyExists(item.getItemName());
		if (isItemAlreadyPresent) {
			response.setMessage(Constants.ITEM_ALREADY_EXISTS);
			response.setStatus(Constants.FAILURE);
			return response;
		}
		if (item.getNumOfItem() < 0) {
			response.setMessage(Constants.QUANTITY_SHOULD_BE_GREATER_THAN_0);
			response.setStatus(Constants.FAILURE);
			return response;
		}
		String status = ecommerceDao.addItem(item);
		if (status.equals(Constants.SUCCESS)) {
			response.setMessage(Constants.ITEM_ADDED);
		}
		response.setStatus(status);
		return response;
	}

	private boolean checkIfItemAlreadyExists(String itemName) {
		List<Item> items = ecommerceDao.getItems();
		for (Item existedItem : items) {
			if (existedItem.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
		
	}

	public ItemResponse deleteItem(String itemName) {
		ItemResponse response = new ItemResponse();
		boolean isItemPresent = checkIfItemAlreadyExists(itemName);
		if (!isItemPresent) {
			response.setMessage(Constants.ITEM_DOES_NOT_EXISTS);
			response.setStatus(Constants.FAILURE);
			return response;
		}
		String status = ecommerceDao.deleteItem(itemName);
		if (status.equals(Constants.SUCCESS)) {
			response.setMessage(Constants.ITEM_DELETED);
		}
		response.setStatus(status);
		return response;
	}

	public ItemResponse updateItem(String itemName, Item item) {
		ItemResponse response = new ItemResponse();
		boolean isItemPresent = checkIfItemAlreadyExists(itemName);
		if (!isItemPresent) {
			response.setMessage(Constants.ITEM_DOES_NOT_EXISTS);
			response.setStatus(Constants.FAILURE);
			return response;
		}
		if (item.getNumOfItem() < 0) {
			response.setMessage(Constants.QUANTITY_SHOULD_BE_GREATER_THAN_0);
			response.setStatus(Constants.FAILURE);
			return response;
		}
		String status = ecommerceDao.updateItem(itemName, item);
		if (status.equals(Constants.SUCCESS)) {
			response.setMessage(Constants.ITEM_UPDATED);
		}
		response.setStatus(status);
		return response;
	}

	public ItemResponse getItems() {
		List<Item> items = ecommerceDao.getItems();
		ItemResponse response = new ItemResponse();
		if (items == null) {
			response.setStatus(Constants.FAILURE);
		} else {
			response.setStatus(Constants.SUCCESS);
		}
		response.setItems(items);
		return response;
	}
	
	public OrderResponse placeOrder(List<Order> orders) {
		OrderResponse response = new OrderResponse();
		String orderVerificationStatus = verifyOrders(orders);
		if (!orderVerificationStatus.equals(Constants.SUCCESS)) {
			response.setMessage(orderVerificationStatus);
			response.setStatus(Constants.FAILURE);
			return response;
		}
		String orderID = UUID.randomUUID().toString();
		for (Order order : orders) {
			order.setOrderID(orderID);
		}
		String status = ecommerceDao.placeOrders(orders);
		if (status.equals(Constants.SUCCESS)) {
			response.setMessage(Constants.ORDER_PLACED);
			updateItems(orders);
		}
		response.setStatus(status);
		return response;
	}

	private void updateItems(List<Order> orders) {
		for (Order order : orders) {
			Item item = ecommerceDao.getItem(order.getItemName());
			Item newItem = new Item();
			newItem.setItemName(order.getItemName());
			newItem.setNumOfItem(item.getNumOfItem() - order.getNumOfItem());
			ecommerceDao.updateItem(order.getItemName(), newItem);
		}
		
	}

	private String verifyOrders(List<Order> orders) {
		for (Order order : orders) {
			Item item = ecommerceDao.getItem(order.getItemName());
			if (item.getNumOfItem() == 0) {
				return Constants.ONE_OR_MORE_ITEM_IS_OUT_OF_STOCK;
			}
			if (item.getNumOfItem() < order.getNumOfItem()) {
				return Constants.ONE_OR_MORE_ITEM_STOCK_IS_LESS_THAN_ORDERED_VALUE;
			}
		}
		return Constants.SUCCESS;
	}

	public OrderResponse getOrders() {
		List<Order> orders = ecommerceDao.getOrders();
		OrderResponse response = new OrderResponse();
		if (orders == null) {
			response.setStatus(Constants.FAILURE);
		} else {
			response.setStatus(Constants.SUCCESS);
		}
		response.setOrders(orders);
		return response;
	}
}

package com.sample.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.ecommerce.dto.OrderResponse;
import com.sample.ecommerce.model.Order;
import com.sample.ecommerce.model.OrderWrapper;
import com.sample.ecommerce.service.EcommerceService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private EcommerceService ecommerceService;
	
	@PostMapping("/order")
	public OrderResponse placeOrder(@RequestBody OrderWrapper orderWrapper) {
		List<Order> orders = orderWrapper.getOrders();
		return ecommerceService.placeOrder(orders);
	}

	@GetMapping("/order")
	public OrderResponse getOrders() {
		return ecommerceService.getOrders();
	}

}

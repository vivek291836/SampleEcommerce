package com.sample.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.ecommerce.dto.ItemResponse;
import com.sample.ecommerce.model.Item;
import com.sample.ecommerce.service.EcommerceService;

@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	private EcommerceService ecommerceService;
	
	@PostMapping("/item")
	public ItemResponse addItem(@RequestBody Item item) {
		return ecommerceService.addItem(item);
	}

	@DeleteMapping("/item/{itemName}")
	public ItemResponse deleteItem(@PathVariable String itemName) {
		return ecommerceService.deleteItem(itemName);
	}

	@PutMapping("/item/{itemName}")
	public ItemResponse updateItem(@PathVariable String itemName, @RequestBody Item item) {
		return ecommerceService.updateItem(itemName, item);
	}

	@GetMapping("/item")
	public ItemResponse getItems() {
		return ecommerceService.getItems();
	}

}

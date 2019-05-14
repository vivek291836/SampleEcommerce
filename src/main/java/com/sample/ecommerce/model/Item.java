package com.sample.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ItemTable")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;	
	
	@Column(unique = true)
	private String itemName;
	
	private int numOfItem;

	
	public Item() {
		super();
	}
	public Item(int id, String itemName, int numOfItem) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.numOfItem = numOfItem;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getNumOfItem() {
		return numOfItem;
	}
	public void setNumOfItem(int numOfItem) {
		this.numOfItem = numOfItem;
	}
}

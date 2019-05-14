package com.sample.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="OrderTable")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String orderID;
	
	private String itemName;
	
	private int numOfItem;
	
	private String emailID;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, String orderID, String itemName, int numOfItem, String emailID) {
		super();
		this.id = id;
		this.orderID = orderID;
		this.itemName = itemName;
		this.numOfItem = numOfItem;
		this.emailID = emailID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
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

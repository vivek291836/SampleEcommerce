package com.sample.ecommerce.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.ecommerce.constant.Constants;
import com.sample.ecommerce.model.Item;
import com.sample.ecommerce.model.Order;

@Repository
public class EcommerceDaoImpl implements EcommerceDao {

	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public String addItem(Item item) {
		String status = Constants.SUCCESS;;
		try {
			getSession().save(item);
		} catch (Exception e) {
			status = Constants.FAILURE;
		}
		return status;
	}

	@Override
	public String deleteItem(String itemName) {
		String status = Constants.SUCCESS;;
		try {
			List<Item> items = getSession().createCriteria(Item.class).add(Restrictions.eq("itemName", itemName)).list();
		    Item item = items.get(0);
		    getSession().delete(item);
		} catch (Exception e) {
			status = Constants.FAILURE;
		}
		return status;
	}

	@Override
	public String updateItem(String itemName, Item item) {
		int numOfItem = 0;
		if (item != null) {
			numOfItem = item.getNumOfItem();
		}
		String status = Constants.SUCCESS;;
		try {
			List<Item> items = getSession().createCriteria(Item.class).add(Restrictions.eq("itemName", itemName)).list();
		    Item updateItem = items.get(0);
		    updateItem.setNumOfItem(numOfItem);
		} catch (Exception e) {
			status = Constants.FAILURE;
		}
		return status;
	}

	@Override
	public List<Item> getItems() {
		try {
			List<Item> items = getSession().createCriteria(Item.class).list();
			return items;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String placeOrders (List<Order> orders) {
		String status = Constants.SUCCESS;;
		try {
			for (Order order : orders) {
				getSession().save(order);
			}
		} catch (Exception e) {
			status = Constants.FAILURE;
		}
		return status;
	}

	@Override
	public List<Order> getOrders() {
		try {
			List<Order> orders = getSession().createCriteria(Order.class).list();
		    return orders;
		} catch (Exception e) {
			return null;
		} 
	}
	
	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException e) {
			session = factory.openSession();
		}
		return session;
	}

	@Override
	public Item getItem(String itemName) {
		return (Item) getSession().createCriteria(Item.class).add(Restrictions.eq("itemName", itemName)).list().get(0);
	}
}

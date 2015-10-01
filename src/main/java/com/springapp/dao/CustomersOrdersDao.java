package com.springapp.dao;

import com.springapp.model.CustomerOrder;

import java.util.ArrayList;

public interface CustomersOrdersDao {
	public abstract CustomerOrder getOrderByOrderId(int id);
	public abstract void cancelOrder(CustomerOrder customerOrder);
	public abstract ArrayList<CustomerOrder> getOrdersByCustomerId(int customerId);
	public abstract CustomerOrder markOrderAsDispatched(CustomerOrder customerOrder);
	public abstract CustomerOrder markOrderAsDelivered(CustomerOrder customerOrder);
	public abstract CustomerOrder updateOrder(CustomerOrder customerOrder);
	public abstract CustomerOrder createCustomerOrder(CustomerOrder customerOrder);

}

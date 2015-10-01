package com.springapp.dao;

import com.springapp.model.ProductOrder;

import java.util.List;

public interface WarehouseOrdersDao {
	public abstract ProductOrder getOrderByOrderId(int id);
	public abstract void cancelOrder(ProductOrder warehouseOrder);
	public abstract List<ProductOrder> getOrdersByCustomerId(int customerId);
	//public abstract List getProducts();
}

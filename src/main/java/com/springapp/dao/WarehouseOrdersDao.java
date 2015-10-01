package com.springapp.dao;

import com.springapp.model.WarehouseOrder;

import java.util.List;

public interface WarehouseOrdersDao {
	public abstract WarehouseOrder getOrderByOrderId(int id);
	public abstract void cancelOrder(WarehouseOrder warehouseOrder);
	public abstract List<WarehouseOrder> getOrdersByCustomerId(int customerId);
	//public abstract List getProducts();
}

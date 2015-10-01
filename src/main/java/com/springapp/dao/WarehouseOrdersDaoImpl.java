package com.springapp.dao;

import com.springapp.model.ProductOrder;

import java.util.List;

public class WarehouseOrdersDaoImpl implements WarehouseOrdersDao {

	@Override
	public ProductOrder getOrderByOrderId(int id) {
		return null;
	}

	@Override
	public void cancelOrder(ProductOrder warehouseOrder) {

	}
	@Override
	public List<ProductOrder> getOrdersByCustomerId(int customerId) {
		return null;
	}
}

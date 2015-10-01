package com.springapp.dao;

import com.springapp.model.Customer;
import com.springapp.model.CustomerImpl;

public interface CustomersDao {
	public abstract Customer getCustomerById(int customerId);
	public abstract Customer createCustomer(CustomerImpl customer);
	public abstract void deleteCustomer(CustomerImpl customer);
	public abstract Customer updateCustomer(CustomerImpl customer);
}

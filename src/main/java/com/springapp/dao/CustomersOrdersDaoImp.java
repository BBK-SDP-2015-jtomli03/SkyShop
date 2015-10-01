package com.springapp.dao;

import com.heroku.sdk.jdbc.DatabaseUrl;
import com.springapp.model.Customer;
import com.springapp.model.CustomerOrder;
import com.springapp.model.Product;
import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomersOrdersDaoImp implements CustomersOrdersDao {

	@Override
	public CustomerOrder getOrderByOrderId(int id) {
		return null;
	}

	@Override
	public void cancelOrder(CustomerOrder customerOrder) {

	}


	@Override
	public ArrayList<CustomerOrder> getOrdersByCustomerId(int customerId) {
		Connection connection = null;
		ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();

		try {
			connection = DatabaseUrl.extract().getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM CustomerOrders WHERE customerId = " + customerId;
			ResultSet rs = stmt.executeQuery(query);

			//while the customer has orders
			while(rs.next()){
				Statement newStmt = connection.createStatement();

				//get the specific order details
				String innerQuery = "SELECT * FROM CustomerOrdersDetails WHERE orderId = " + rs.getInt("id");
				ResultSet innerQueryrs = stmt.executeQuery(innerQuery);
				CustomerOrder customerOrder = null;

				while(innerQueryrs.next()){
					HashMap productsDelivered = new HashMap<Product, Map<DateTime, Integer>>();
					HashMap productsDispatched = new HashMap<Product, Map<DateTime, Integer>>();
					HashMap productsOrdered = new HashMap<DateTime, Integer>();

					//get the order date
					DateTime orderedPlaceDate = new DateTime(innerQueryrs.getTimestamp("orderDate"));

					//get the customer
					CustomersDaoImp customerDao = new CustomersDaoImp();
					Customer customer = customerDao.getCustomerById(rs.getInt("customerId"));

					//get the product
					int productId = rs.getInt("productId");
					ProductCatalogueDaoImp prodCatDao = new ProductCatalogueDaoImp();
					Product product = prodCatDao.getProductById(productId);

					//if the products are delivered then add into productsDelivered
					if(innerQueryrs.getBoolean("isDelivered")){
						Map<DateTime, Integer> deliveredDateMap = new HashMap<DateTime, Integer>();
						DateTime deliveredDate = new DateTime(innerQueryrs.getTimestamp("deliveredDate"));
						deliveredDateMap.put(deliveredDate, innerQueryrs.getInt("quantity"));
						productsDispatched.put(product, deliveredDateMap);
					}

					//if the products are dispatched then add into productsDispatched
					if(innerQueryrs.getBoolean("isDispatched")){
						Map<DateTime, Integer> dispatchedDateMap = new HashMap<DateTime, Integer>();
						DateTime dispatchedDate = new DateTime(innerQueryrs.getTimestamp("deliveredDate"));
						dispatchedDateMap.put(dispatchedDate, innerQueryrs.getInt("quantity"));
						productsDispatched.put(product, dispatchedDateMap);
					}

					productsOrdered.put(product, rs.getInt("quantityOrdered"));

					customerOrder = new CustomerOrder(
							orderedPlaceDate,
							productsOrdered,
							productsDispatched,
							productsDelivered,
							rs.getBigDecimal("totalPrice"),
							customer
					);
				}

				if(customerOrder != null)
					customerOrders.add(customerOrder);
			}
		} catch (Exception e){

		}
		finally {
			if (connection != null) try{connection.close();} catch(SQLException e){}
		}
		return customerOrders;
	}

	@Override
	public CustomerOrder markOrderAsDispatched(CustomerOrder customerOrder) {
		return null;
	}

	@Override
	public CustomerOrder markOrderAsDelivered(CustomerOrder customerOrder) {
		return null;
	}

	@Override
	public CustomerOrder updateOrder(CustomerOrder customerOrder) {
		return null;
	}

	@Override
	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		return null;
	}
}

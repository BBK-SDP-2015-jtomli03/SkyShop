package com.springapp.model;

import com.springapp.service.CustomerOrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jo on 01/10/2015.
 */
public class FakeDatabase {
    CustomerOrderService customerOrderService;

    Product product1 = new ProductImpl(1, 2, "productCode", "String name", "String description", new BigDecimal(2.00), "String imageUrl");
    Product product2 = new ProductImpl(2, 2, "productCode", "Gnome", "String description", new BigDecimal(2.00), "String imageUrl");
    Product product3 = new ProductImpl(3, 2, "productCode", "Remote", "String description", new BigDecimal(2.00), "String imageUrl");

    Map<Product, Integer> productsOrdered = new HashMap<Product, Integer>();
    productsOrdered.put(product1, 10);
    productsOrdered.put(product2, 20);
    productsOrdered.put(product3, 30);

    Map<Product, Integer> productsOrdered2 = new HashMap<Product, Integer>();
    productsOrdered.put(product1, 100);
    productsOrdered.put(product2, 200);
    productsOrdered.put(product3, 300);

    Customer customer = new CustomerImpl();

    CustomerOrder order = new CustomerOrder(productsOrdered, new BigDecimal(10.00), customer);
    CustomerOrder order2 = new CustomerOrder(productsOrdered2, new BigDecimal(50.00), customer);

    List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
    orders.add(order);
    orders.add(order2);

    WarehouseBrain.getWarehouseBrain().addCustomerOrder(order);
    WarehouseBrain.getWarehouseBrain().addCustomerOrder(order2);
}

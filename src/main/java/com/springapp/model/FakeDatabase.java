package com.springapp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jo on 01/10/2015.
 */
public class FakeDatabase {
    private List<Product> products = new ArrayList<Product>();
    private List<Customer> customers = new ArrayList<Customer>();
    private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();



    public FakeDatabase(){
        Product product1 = new ProductImpl(1, 2, "productCode", "String name", "String description", new BigDecimal(2.00), "String imageUrl");
        Product product2 = new ProductImpl(2, 2, "productCode", "Gnome", "String description", new BigDecimal(2.00), "String imageUrl");
        Product product3 = new ProductImpl(3, 2, "productCode", "Remote", "String description", new BigDecimal(2.00), "String imageUrl");
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Customer customer1 = new CustomerImpl();
        Customer customer2 = new CustomerImpl();
        Customer customer3 = new CustomerImpl();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        Map<Product, Integer> productsOrdered = new HashMap<Product, Integer>();
        productsOrdered.put(product1, 10);
        productsOrdered.put(product2, 20);
        productsOrdered.put(product3, 30);

        Map<Product, Integer> productsOrdered2 = new HashMap<Product, Integer>();
        productsOrdered.put(product1, 100);
        productsOrdered.put(product2, 200);
        productsOrdered.put(product3, 300);

        CustomerOrder order = new CustomerOrder(productsOrdered, new BigDecimal(10.00), customer1);
        CustomerOrder order2 = new CustomerOrder(productsOrdered2, new BigDecimal(50.00), customer2);

        customerOrders.add(order);
        customerOrders.add(order2);
    }

    // ADD A PRODUCT
    public void addProduct(Product product){
        products.add(product);
    }

    // FIND CUSTOMER ORDER BY ORDER NUMBER
    public Order findCustomerOrderByOrderNumber(long orderNumber){
        for(CustomerOrder order : customerOrders){
            if(order.getOrderNumber() == orderNumber){
                return order;
            }
        }
        return null;
    }

}

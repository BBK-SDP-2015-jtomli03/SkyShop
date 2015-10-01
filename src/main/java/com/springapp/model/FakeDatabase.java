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
    private List<Order> customerOrders = new ArrayList<Order>();

    public FakeDatabase(){
        List<Supplier> suppliers = new ArrayList<Supplier>();
        Product product1 = new ProductImpl(1, "productCode", "String name", "String shortdescription", "longDescription", new BigDecimal(2.00), "String imageUrl", 10, suppliers, "H", "20", 5, false);
        Product product2 = new ProductImpl(1, "productCode", "Gnome", "shortdescription", "longDescription", new BigDecimal(2.00), "String imageUrl", 10, suppliers, "H", "20", 5, false);
        Product product3 = new ProductImpl(1, "productCode", "Remote", "shortdescription", "longDescription", new BigDecimal(2.00), "String imageUrl", 10, suppliers, "H", "20", 5, false);
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
        productsOrdered.put(product1, 1);
        productsOrdered.put(product2, 2);
        productsOrdered.put(product3, 3);

        Map<Product, Integer> productsOrdered2 = new HashMap<Product, Integer>();
        productsOrdered.put(product1, 1);
        productsOrdered.put(product2, 2);
        productsOrdered.put(product3, 3);

        CustomerOrder order = new CustomerOrder(productsOrdered, new BigDecimal(10.00), customer1);
        CustomerOrder order2 = new CustomerOrder(productsOrdered2, new BigDecimal(50.00), customer2);

        customerOrders.add(order);
        customerOrders.add(order2);

        WarehouseBrain.getWarehouseBrain().addCustomerOrder(order);
        WarehouseBrain.getWarehouseBrain().addCustomerOrder(order2);

    }

    // ADD A PRODUCT
    public void addProduct(Product product){
        products.add(product);
    }

    // FIND CUSTOMER ORDER BY ORDER NUMBER
    public Order findCustomerOrderByOrderNumber(long orderNumber){
        for(Order order : customerOrders){
            if(order.getOrderNumber() == orderNumber){
                return order;
            }
        }
        return null;
    }

    public Product getProduct(int productId){
        for(Product product : products){
            if(product.getId() == productId){
                return product;
            }
        }
        return null;
    }

    public void persist(Product product){
        products.add(product);
    }

    public void update(Product product){
        //to implement
    }

    public Customer getCustomer(int id){
        for(Customer customer : customers){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    public void addCustomerOrder(Order order){
        customerOrders.add(order);
    }

}

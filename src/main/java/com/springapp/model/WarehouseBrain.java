package com.springapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jo on 28/09/2015.
 */
public class WarehouseBrain {
    private static WarehouseBrain warehouseBrain = new WarehouseBrain();
    List<Order> productOrders = new ArrayList<Order>();
    List<Order> customerOrders = new ArrayList<Order>();

    private WarehouseBrain(){

    }

    public static WarehouseBrain getWarehouseBrain(){
        return warehouseBrain;
    }

    public List<Order> getProductOrders() {
        return productOrders;
    }

    public List<Order> getCustomerOrders() {
        return customerOrders;
    }

    public Order getNextCustomerOrder(){
        Order order = null;
        if(customerOrders != null && !customerOrders.isEmpty()){
            order = customerOrders.get(0);
            customerOrders.remove(0);
        }
        return order;
    }

    //adds a product order to the list
    public void addProductOrder(Order productOrder){
        productOrders.add(productOrder);
    }

    //adds a customer order to the list
    public void addCustomerOrder(Order customerOrder){
        customerOrders.add(customerOrder);
    }

    public Order getCustomerOrder(long num){
        Order order = null;
        if(customerOrders != null && !customerOrders.isEmpty()){
            order = customerOrders.get(2);
        }
        return order;
    }
}

package com.springapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jo on 28/09/2015.
 */
public class WarehouseBrain {
    private static WarehouseBrain warehouseBrain = new WarehouseBrain();
    List<ProductOrder> productOrders = new ArrayList<ProductOrder>();
    List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();

    private WarehouseBrain(){

    }

    public static WarehouseBrain getWarehouseBrain(){
        return warehouseBrain;
    }

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public CustomerOrder getNextCustomerOrder(){
        CustomerOrder order = null;
        if(customerOrders != null && !customerOrders.isEmpty()){
            order = customerOrders.get(0);
            customerOrders.remove(0);
        }
        return order;
    }

    //adds a product order to the list
    public void addProductOrder(ProductOrder productOrder){
        productOrders.add(productOrder);
    }

    //adds a customer order to the list
    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrders.add(customerOrder);
    }
}

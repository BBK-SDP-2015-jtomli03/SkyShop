package com.springapp.model;

import java.util.List;

/**
 * Created by Jo on 28/09/2015.
 */
public class WarehouseBrain {
    private static WarehouseBrain warehouseBrain = new WarehouseBrain();
    List<ProductOrder> productOrders;
    List<CustomerOrder> customerOrders;

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

    //adds a product order to the list
    public void addProductOrder(ProductOrder productOrder){
        productOrders.add(productOrder);
    }

    //adds a customer order to the list
    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrders.add(customerOrder);
    }
}

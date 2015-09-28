package com.springapp.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jo on 27/09/2015.
 */
public interface Order {

    //****customer order and purchase order*****

    void orderProducts(List<Product> productsToOrder, Integer quantity);

    //return a map of products & quantities on this order
    Map<Product, Integer> getProductsOrdered();

    Double getTotalPrice();

    //returns the customer who placed the order
    String getCustomer();

    Date getDateOrderPlaced();

    void productDispatched(Product product, Integer quantity);

    //check products already dispatched from this order and the date they were dispatched and the quantity dispatched
    Map<Product, Map<Date, Integer>> getDispatchedProducts();

    void productDelivered(Product product, Integer quantity);

    //check products already delivered from this order, the date they were delivered and the quantity delivered
    Map<Product, Map<Date, Integer>> getDeliveredProducts();


}

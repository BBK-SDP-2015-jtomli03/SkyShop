package com.springapp.model;

import java.util.List;

/**
 * Created by Jo on 27/09/2015.
 */
public interface Customer {

    //logged in
    //guest

    //returns a list of the customers orders
    List<Order> getOrders();

    void addOrder(Order order);

    Address getAddress();

    String getTitleAndFullName();

    int getId();
}

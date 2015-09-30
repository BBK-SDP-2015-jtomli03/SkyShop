package com.springapp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jo on 27/09/2015.
 */
public class Cart {
    //private Map<Integer, Integer> products = new HashMap<Integer, Integer>();
    private String[] products;
    private String[] quantities;
    private double totalPrice;
    private String customer;

    public String[] getProducts(){
        return this.products;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }

    public String[] getQuantities() {
        return quantities;
    }

    public void setQuantities(String[] quantities) {
        this.quantities = quantities;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}

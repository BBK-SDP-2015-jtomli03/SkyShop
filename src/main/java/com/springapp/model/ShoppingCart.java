package com.springapp.model;

import java.util.Map;

/**
 * Created by Jo on 27/09/2015.
 */
public interface ShoppingCart {

    void addProduct(Product product);

    void removeProduct(Product product);

    // product & quantity
    Map<Product, Integer> getContents();

    Double calculateTotalPrice();

    //remove the bean instance
    void remove();

}

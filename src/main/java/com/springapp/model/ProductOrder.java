package com.springapp.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jo on 28/09/2015.
 */
public class ProductOrder implements Order {
    private int orderNumber;
    private Product product;
    private int quantity;
    private Date dateOrdered;
    private Date dateDueToBeDelivered;


    public ProductOrder(Product product){
        this.product = product;
        this.quantity = product.getReorderLevel() * 2;
        this.dateOrdered = new Date();
    }

    public ProductOrder(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        this.dateOrdered = new Date();
    }

    @Override
    public void orderProducts(List<Product> productsToOrder, Integer quantity) {

    }

    @Override
    public Map<Product, Integer> getProductsOrdered() {
        return null;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public Customer getCustomer() {
        return null;
    }

    @Override
    public DateTime getDateOrderPlaced() {
        return null;
    }

    @Override
    public void setProductDispatched(Product product, Integer quantity) {

    }

    @Override
    public Map<Product, Map<DateTime, Integer>> getDispatchedProducts() {
        return null;
    }

    @Override
    public void productDelivered(Product product, Integer quantity) {

    }

    @Override
    public Map<Product, Map<DateTime, Integer>> getDeliveredProducts() {
        return null;
    }
}

package com.springapp.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jo on 28/09/2015.
 */
public class CustomerOrder implements Order {
    private static long orderNumberCounter = 0;
    private final long orderNumber = setOrderNumber();
    private Map<Product, Integer> productsOrdered;
    private Map<Product, Map<Date, Integer>> productsDispatched;
    private Map<Product, Map<Date, Integer>> productsDelivered;
    private BigDecimal totalPrice;
    private Customer customer;

    public CustomerOrder(Map<Product, Integer> productsOrdered, BigDecimal totalPrice, Customer customer) {
        this.productsOrdered = productsOrdered;
        this.productsDispatched = null;
        this.productsDelivered = null;
        this.totalPrice = totalPrice;
        this.customer = customer;
    }

    private long setOrderNumber() {
        orderNumberCounter += 1;
        return orderNumberCounter;
    }

//    private BigDecimal getTotalPrice(Map<Product, Integer> productsOrdered){
//        BigDecimal totalPrice = BigDecimal.ZERO;
//        for(Map.Entry<Product, Integer> entry : productsOrdered.entrySet()){
//            int quantity = entry.getValue();
//            totalPrice.add(entry.getKey().getPrice().multiply(new BigDecimal(quantity)));
//        }
//        return totalPrice;
//    }

    @Override
    public void orderProducts(List<Product> productsToOrder, Integer quantity) {
        int productStockLevel;
        for(Product product: productsToOrder){
            productStockLevel = product.adjustStockLevel(quantity);
            reorderProduct(product, productStockLevel);
        }
        WarehouseBrain.getWarehouseBrain().addCustomerOrder(this);
    }

    //reorders a product if below reorder level and not discontinued
    public void reorderProduct(Product product, int productStockLevel){
        if(productStockLevel < product.getReorderLevel() && !product.isDiscontinued()){
            new ProductOrder(product);
        }else if(productStockLevel == 0 && product.isDiscontinued()){
            ProductCatalogue.getCatalogue().removeProduct(product);
        }
        //else do nothing and let stock run down as the product is discontinued but still available.
    }

    @Override
    public Map<Product, Integer> getProductsOrdered() {
        return null;
    }

    @Override
    public Double getTotalPrice() {
        return null;
    }

    @Override
    public String getCustomer() {
        return null;
    }

    @Override
    public Date getDateOrderPlaced() {
        return null;
    }

    @Override
    public void productDispatched(Product product, Integer quantity) {

    }

    @Override
    public Map<Product, Map<Date, Integer>> getDispatchedProducts() {
        return null;
    }

    @Override
    public void productDelivered(Product product, Integer quantity) {

    }

    @Override
    public Map<Product, Map<Date, Integer>> getDeliveredProducts() {
        return null;
    }

    public static long getOrderNumberCounter(){
        return orderNumberCounter;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setProductsOrdered(Map<Product, Integer> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }

    public Map<Product, Map<Date, Integer>> getProductsDispatched() {
        return productsDispatched;
    }

    public void setProductsDispatched(Map<Product, Map<Date, Integer>> productsDispatched) {
        this.productsDispatched = productsDispatched;
    }

    public Map<Product, Map<Date, Integer>> getProductsDelivered() {
        return productsDelivered;
    }

    public void setProductsDelivered(Map<Product, Map<Date, Integer>> productsDelivered) {
        this.productsDelivered = productsDelivered;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

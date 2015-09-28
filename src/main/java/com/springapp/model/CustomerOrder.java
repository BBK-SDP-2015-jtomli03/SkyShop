package com.springapp.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jo on 28/09/2015.
 */
public class CustomerOrder implements Order {
    private int orderNumber;
    private Map<Product, Integer> productsOrdered;
    private Map<Product, Map<Date, Integer>> productsDispatched;
    private Map<Product, Map<Date, Integer>> productsDelivered;
    private BigDecimal totalPrice;
    private CustomerImpl customer;


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
}

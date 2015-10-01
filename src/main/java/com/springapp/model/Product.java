package com.springapp.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jo on 27/09/2015.
 */
public interface Product {

    // price
    BigDecimal getPrice();
    void setPrice(BigDecimal price);

    // name
    String getName();
    void setName(String name);

    //shortDescription
    String getShortDescription();
    void setShortDescription(String description);

    // longDescription
    String getLongDescription();
    void setLongDescription(String longDescription);

    // productSupplier
    void addProductSupplier(Supplier supplier);
    List<Supplier> getProductSuppliers();

    // productCode
    String getProductCode();
    void setProductCode(String productCode);


    void setSuppliers(List<Supplier> suppliers);

    boolean isDiscontinued();

    int getStockLevel();

    int adjustStockLevel(int numOfItemsBought);

    int getReorderLevel();
}

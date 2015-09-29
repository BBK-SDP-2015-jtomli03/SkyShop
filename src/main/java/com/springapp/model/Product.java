package com.springapp.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jo on 27/09/2015.
 */
public interface Product {

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    void addProductSupplier(Supplier supplier);

    List<Supplier> getProductSuppliers();

    String getProductCode();

    void setProductCode(String productCode);

    void setSuppliers(List<Supplier> suppliers);

    boolean isDiscontinued();

    int getStockLevel();

    int adjustStockLevel(int numOfItemsBought);

    int getReorderLevel();
}

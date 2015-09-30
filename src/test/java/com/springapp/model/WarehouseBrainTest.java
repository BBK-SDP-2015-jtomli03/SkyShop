package com.springapp.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jo on 30/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class WarehouseBrainTest {
    WarehouseBrain warehouseBrain;
    Customer customer;
    Map<Product, Integer> productsOrdered;
    Product product;
    CustomerOrder customerOrder;

    @Before
    public void setup() {
        product = new ProductImpl(1, 1, "code", "product", "aproduct", new BigDecimal(1.00), "image");
        productsOrdered = new HashMap<Product, Integer>();
        productsOrdered.put(product, 1);
        customer = new CustomerImpl();
        customerOrder = new CustomerOrder(productsOrdered, new BigDecimal(10.00), customer);
    }

    @Test
    public void testgetNextCustomerOrderIfNoCustomerOrders() {
        CustomerOrder expected = null;
        CustomerOrder result = WarehouseBrain.getWarehouseBrain().getNextCustomerOrder();
        assertEquals(expected, result);
    }

    @Test
    public void testgetNextCustomerOrderIfOneCustomerOrder() {
        WarehouseBrain.getWarehouseBrain().addCustomerOrder(customerOrder);
        BigDecimal expected = new BigDecimal(10.00);
        BigDecimal result = WarehouseBrain.getWarehouseBrain().getNextCustomerOrder().getTotalPrice();
        assertEquals(expected, result);
    }
}

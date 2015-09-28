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
 * Created by Jo on 28/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CustomerOrderTest {
    CustomerOrder customerOrder;
    Customer customer;
    Map<Product, Integer> productsOrdered;
    Product product;

    @Before
    public void setup() {
        product = new ProductImpl(1, 1, "code", "product", "aproduct", new BigDecimal(1.00), "image");
        productsOrdered = new HashMap<Product, Integer>();
        productsOrdered.put(product, 1);
        customer = new CustomerImpl();
    }

    @Test
    public void testSetOrderNumberCorrectWhenInitialisingAnOrder() {
        customerOrder = new CustomerOrder(productsOrdered, new BigDecimal(1.00), customer);
        long expected = CustomerOrder.getOrderNumberCounter();
        long result = customerOrder.getOrderNumber();
        assertEquals(expected, result);
    }
}

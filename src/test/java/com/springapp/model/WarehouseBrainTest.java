package com.springapp.model;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jo on 30/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class WarehouseBrainTest {
//    WarehouseBrain warehouseBrain;
//    Customer customer;
//    Map<Product, Integer> productsOrdered;
//    Product product;
//    Product product2;
//    CustomerOrder customerOrder;
//    CustomerOrder customerOrder2;
//
//    @Before
//    public void setup() {
//        product = new ProductImpl(1, 10, "code", "product", "aproduct", new BigDecimal(1.00), "image");
//        product2 = new ProductImpl(2, 20, "code", "product", "aproduct", new BigDecimal(2.00), "image");
//        productsOrdered = new HashMap<Product, Integer>();
//        productsOrdered.put(product, 1);
//        productsOrdered.put(product2, 1);
//        customer = new CustomerImpl();
//        customerOrder = new CustomerOrder(productsOrdered, new BigDecimal(10.00), customer);
//        customerOrder2 = new CustomerOrder(productsOrdered, new BigDecimal(20.00), customer);
//    }
//
//    @Test
//    public void testgetNextCustomerOrderIfNoCustomerOrders() {
//        Order expected = null;
//        Order result = WarehouseBrain.getWarehouseBrain().getNextCustomerOrder();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testgetNextCustomerOrderIfOneCustomerOrder() {
//        WarehouseBrain.getWarehouseBrain().addCustomerOrder(customerOrder);
//        BigDecimal expected = new BigDecimal(10.00);
//        BigDecimal result = WarehouseBrain.getWarehouseBrain().getNextCustomerOrder().getTotalPrice();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testgetNextCustomerOrderIfMoreThanOneCustomerOrder() {
//        WarehouseBrain.getWarehouseBrain().addCustomerOrder(customerOrder);
//        WarehouseBrain.getWarehouseBrain().addCustomerOrder(customerOrder2);
//        BigDecimal expected = new BigDecimal(10.00);
//        BigDecimal result = WarehouseBrain.getWarehouseBrain().getNextCustomerOrder().getTotalPrice();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testNextCustomerOrderIsRemovedWhenGetNextCustomerOrder() {
//        WarehouseBrain.getWarehouseBrain().addCustomerOrder(customerOrder);
//        WarehouseBrain.getWarehouseBrain().addCustomerOrder(customerOrder2);
//        BigDecimal expected = new BigDecimal(10.00);
//        BigDecimal result = WarehouseBrain.getWarehouseBrain().getNextCustomerOrder().getTotalPrice();
//        assertEquals(expected, result);
//    }
}

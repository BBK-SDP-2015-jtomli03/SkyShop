package com.springapp.model;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jo on 28/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CustomerOrderTest {
//    CustomerOrder customerOrder;
//    Customer customer;
//    Map<Product, Integer> productsOrdered;
//    Product product;
//
//    @Before
//    public void setup() {
//        product = new ProductImpl(1, 10, "code", "product", "aproduct", new BigDecimal(1.00), "image");
//        productsOrdered = new HashMap<Product, Integer>();
//        productsOrdered.put(product, 1);
//        customer = new CustomerImpl();
//    }
//
//    @Test
//    public void testSetOrderNumberCorrectWhenInitialisingAnOrder() {
//        customerOrder = new CustomerOrder(productsOrdered, new BigDecimal(1.00), customer);
//        long expected = CustomerOrder.getOrderNumberCounter();
//        long result = customerOrder.getOrderNumber();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testSetFullQuantityOfProductDispatched() {
//        customerOrder = new CustomerOrder(productsOrdered, new BigDecimal(1.00), customer);
//        customerOrder.setProductDispatched(product, 10);
//        Map<DateTime, Integer> map = customerOrder.getDispatchedProducts().get(product);
//        int expected = 10;
//        int result = 0;
//        for (Map.Entry<DateTime, Integer> entry : map.entrySet()) {
//            result = entry.getValue();
//        }
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testSetProductDispatchedWithHalfTheQuantityDispatched() {
//        customerOrder = new CustomerOrder(productsOrdered, new BigDecimal(1.00), customer);
//        customerOrder.setProductDispatched(product, 5);
//        Map<DateTime, Integer> map = customerOrder.getDispatchedProducts().get(product);
//        int expected = 5;
//        int result = 0;
//        for (Map.Entry<DateTime, Integer> entry : map.entrySet()) {
//            result = entry.getValue();
//        }
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testSetProductDispatchedWithNoneOfTheProductDispatched() {
//        customerOrder = new CustomerOrder(productsOrdered, new BigDecimal(1.00), customer);
//        customerOrder.setProductDispatched(product, 0);
//        Map<DateTime, Integer>  expected = null;
//        Map<DateTime, Integer>  result = customerOrder.getDispatchedProducts().get(product);
//        assertEquals(expected, result);
//    }

}

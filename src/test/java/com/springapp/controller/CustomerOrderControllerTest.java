package com.springapp.controller;

import com.springapp.model.FakeDatabase;
import com.springapp.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Jo on 01/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CustomerOrderControllerTest {
    CustomerOrderController controller;
    List<Integer> list;
    FakeDatabase db;

    @Before
    public void setup() {
        controller = new CustomerOrderController();
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        db = new FakeDatabase();
    }

    @Test
    public void testSplitStringAndReturnIntList() {
        String string = "1,2,3";
        List<Integer> actual = controller.splitStringAndReturnIntList(string);
        List<Integer> expected;
        expected = list;
        assertThat(actual, is(expected));
    }

    @Test
    public void addProductsAndQuantitiesToMap(){
        List<Integer> numberOfProductToOrder = new ArrayList<Integer>();
        numberOfProductToOrder.add(1);
        numberOfProductToOrder.add(2);
        numberOfProductToOrder.add(3);
        Map<Product, Integer> expected = new HashMap<Product, Integer>();
        expected.put(db.getProduct(1),1);
        expected.put(db.getProduct(2),2);
        expected.put(db.getProduct(3),3);
        Map<Product, Integer> actual = controller.addProductsAndQuantitiesToMap(list, numberOfProductToOrder);
        assertThat(actual, is(expected));
    }

}

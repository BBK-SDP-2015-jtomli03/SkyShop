package com.springapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Jo on 01/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CustomerOrderControllerTest {
    CustomerOrderController controller;

    @Before
    public void setup() {
        controller = new CustomerOrderController();
    }

    @Test
    public void testSplitStringAndReturnIntList() {
        String string = "1,2,3";
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        List<Integer> actual = controller.splitStringAndReturnIntList(string);
        assertThat(actual, is(expected));
    }

}

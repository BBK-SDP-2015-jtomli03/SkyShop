package com.springapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.model.*;
import com.springapp.service.CustomerOrderService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Jo on 28/09/2015.
 */
@Controller
@RequestMapping("/customer/order")
public class CustomerOrderController {
    CustomerOrderService customerOrderService;

//    @RequestMapping(path = "/get/six", method = RequestMethod.GET)
//    public @ResponseBody
//    List<CustomerOrder> getSixOrders() {
//        return WarehouseBrain.getWarehouseBrain().getAndRemoveCustomerOrders(6);
//    }

    //get six orders at a time for warehouse app
    @RequestMapping(value = "/get/six", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getSixOrders() {
        Product product1 = new ProductImpl(1, 2, "productCode", "String name", "String description", new BigDecimal(2.00), "String imageUrl");
        Product product2 = new ProductImpl(1, 2, "productCode", "Gnome", "String description", new BigDecimal(2.00), "String imageUrl");
        Product product3 = new ProductImpl(1, 2, "productCode", "Remote", "String description", new BigDecimal(2.00), "String imageUrl");

        Map<Product, Integer> productsOrdered = new HashMap<Product, Integer>();
        productsOrdered.put(product1, 10);
        productsOrdered.put(product2, 20);
        productsOrdered.put(product3, 30);

        Customer customer = new CustomerImpl();

        //return WarehouseBrain.getWarehouseBrain().getAndRemoveCustomerOrders(6);
        CustomerOrder order = new CustomerOrder(productsOrdered, new BigDecimal(10.00), customer);

        List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
        orders.add(order);

        //order
        String orderNum = String.valueOf(order.getOrderNumber());
        Map<Product, Integer> products = order.getProductsOrdered();
        String customerName = order.getCustomer().getTitleAndFullName();
        String customerAddress = order.getCustomer().getAddress();

        JSONObject SendObject = new JSONObject();
        try {
            String jsonProducts = new ObjectMapper().writeValueAsString(products);
            SendObject.put("OrderNumber", orderNum);
            SendObject.put("Products", jsonProducts);
            SendObject.put("CustomerName", customerName);
            SendObject.put("CustomerAddress", customerAddress);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return SendObject.toString();
    }

    //get a customer order by the orderNumber
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Order getOrderByOrderNumber(@RequestBody long orderNumber) {
        Order order = customerOrderService.findByOrderNumber(orderNumber);
        return order;
    }

    //place a customer order
    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public @ResponseBody void placeOrder(@ModelAttribute("order") CustomerOrder order) {
        WarehouseBrain.getWarehouseBrain().addCustomerOrder(order);
        customerOrderService.persist(order);
        //return ok
    }

    //dispatch a customer order
    @RequestMapping(value = "/dispatched", method = RequestMethod.POST)
    public @ResponseBody void orderDispatched(@ModelAttribute("order") CustomerOrder order) {
        //handle
        //return ok
    }

}

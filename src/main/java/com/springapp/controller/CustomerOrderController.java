package com.springapp.controller;

import com.springapp.model.*;
import com.springapp.service.CustomerOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by Jo on 28/09/2015.
 */
@Controller
@RequestMapping("/order")
public class CustomerOrderController {
    CustomerOrderService customerOrderService;

//    @RequestMapping(path = "/get/six", method = RequestMethod.GET)
//    public @ResponseBody
//    List<CustomerOrder> getSixOrders() {
//        return WarehouseBrain.getWarehouseBrain().getAndRemoveCustomerOrders(6);
//    }

    @RequestMapping(value = "/get/six", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Product getSixOrders() {
        Product product = new ProductImpl(1, 2, "productCode", "String name", "String description", new BigDecimal(2.00), "String imageUrl");
            return product; //*******CHANGE RETURN OBJECT TO ABOVE********
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Order getOrderByOrderNumber(@RequestBody long orderNumber) {
        Order order = customerOrderService.findByOrderNumber(orderNumber);
        return order;
    }

    @RequestMapping(value = "/order/received", method = RequestMethod.POST)
    public @ResponseBody void orderReceived(@RequestBody long orderNumber) {
        //add order to stock
        //return ok
    }

    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public @ResponseBody void placeOrder(@ModelAttribute("order") CustomerOrder order) {
        WarehouseBrain.getWarehouseBrain().addCustomerOrder(order);
        customerOrderService.persist(order);
        //return ok
    }

}

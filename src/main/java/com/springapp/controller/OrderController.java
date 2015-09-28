package com.springapp.controller;

import com.springapp.model.CustomerOrder;
import com.springapp.model.WarehouseBrain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Jo on 28/09/2015.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(path = "/get/six", method = RequestMethod.GET)
    public void getSixOrders() {
        List<CustomerOrder> orders = WarehouseBrain.getWarehouseBrain().getAndRemoveCustomerOrders(6);

    }
}

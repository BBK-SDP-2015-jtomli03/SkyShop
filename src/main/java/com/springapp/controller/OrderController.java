package com.springapp.controller;

import com.springapp.model.Product;
import com.springapp.model.ProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by Jo on 28/09/2015.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

//    @RequestMapping(path = "/get/six", method = RequestMethod.GET)
//    public @ResponseBody
//    List<CustomerOrder> getSixOrders() {
//        return WarehouseBrain.getWarehouseBrain().getAndRemoveCustomerOrders(6);
//    }

    @RequestMapping(value = "/get/six", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Product getSixOrders() {
        Product product = new ProductImpl(1, 2, "productCode", "String name", "String description", new BigDecimal(2.00), "String imageUrl");
            return product;
    }

}

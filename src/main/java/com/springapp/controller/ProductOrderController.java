package com.springapp.controller;

import com.springapp.model.Order;
import com.springapp.model.Product;
import com.springapp.model.ProductCatalogue;
import com.springapp.model.ProductOrder;
import com.springapp.service.ProductOrderService;
import com.springapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jo on 29/09/2015.
 */
@Controller
@RequestMapping("product/order")
public class ProductOrderController {
    ProductOrderService productOrderService = new ProductOrderService();
    ProductService productService = new ProductService();

    //Order a product for stock
    @RequestMapping(path = "/place", method = RequestMethod.GET)
    public void orderProduct() {
        int id = 0; //***********CHANGE TO REFLECT ID SENT**************
        int quantity = 100; //***********CHANGE TO REFLECT QUANTITY SENT**************
        Product product = productService.findById(id);
        if(product.isDiscontinued()){
            //return product discontinued
        }else if(product.getStockLevel() >= 0){
            Order order = productOrderService.getOrder(product); //check if product already on order
            if(order == null){
                new ProductOrder(product, quantity);
            }else{
                //return order info -> product already on order
            }
        }else{
            //product is new and this is the first order, therefore add to the catalogue and place order
            ProductCatalogue.getCatalogue().addProduct(product);
            new ProductOrder(product, quantity);
        }
        //if all gone ok return ok status to client
    }

    //get a product order by order number
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Order getOrderByOrderNumber(@RequestBody long orderNumber) {
        Order order = productOrderService.findByOrderNumber(orderNumber);
        return order;
    }

    //confirm order received ok
    @RequestMapping(value = "/received", method = RequestMethod.POST)
    public @ResponseBody void orderReceived(@RequestBody long orderNumber) {
        //add order to stock
        //return ok
    }


}

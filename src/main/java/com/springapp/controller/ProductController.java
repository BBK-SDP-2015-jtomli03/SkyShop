package com.springapp.controller;

/**
 * Created by Jo on 27/09/2015.
 */

import com.springapp.model.*;
import com.springapp.service.ProductOrderService;
import com.springapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService = new ProductService();
    ProductOrderService productOrderService = new ProductOrderService();

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public void addProduct() {
        String productCode = ""; //check if product exists using product code
        Product product = productService.getProduct(productCode);
        if(product == null){
            //initialise product -> if new product need way of obtaining product id
            productService.persist(product);
        }else{
            //return exists
        }
    }

    @RequestMapping(path = "/add/supplier", method = RequestMethod.GET)
    public void addProductSupplier() {
        int id = 0; //***********CHANGE TO REFLECT ID SENT**************
        List<Supplier> suppliers = new ArrayList<Supplier>();
        Product product = productService.findById(id);
        product.setSuppliers(suppliers);
        productService.update(product); //persist product to DB
        //if all gone ok return ok status to client
    }

    @RequestMapping(path = "/order", method = RequestMethod.GET)
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
}

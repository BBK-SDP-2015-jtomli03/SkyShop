package com.springapp.controller;

/**
 * Created by Jo on 27/09/2015.
 */

import com.springapp.model.FakeDatabase;
import com.springapp.model.Product;
import com.springapp.model.Supplier;
import com.springapp.service.ProductOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    FakeDatabase fakeDatabase = new FakeDatabase();
    ProductOrderService productOrderService = new ProductOrderService();

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public void addProduct() {
        int productCode = 0; //check if product exists using product code
        Product product = fakeDatabase.getProduct(productCode);
        if(product == null){
            //initialise product -> if new product need way of obtaining product id
            fakeDatabase.persist(product);
        }else{
            //return exists
        }
    }

    @RequestMapping(path = "/add/supplier", method = RequestMethod.GET)
    public void addProductSupplier() {
        int id = 0; //***********CHANGE TO REFLECT ID SENT**************
        List<Supplier> suppliers = new ArrayList<Supplier>();
        Product product = fakeDatabase.getProduct(id);
        product.setSuppliers(suppliers);
        fakeDatabase.update(product); //persist product to DB
        //if all gone ok return ok status to client
    }

}

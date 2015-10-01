package com.springapp.controller;

import com.springapp.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by Jo on 28/09/2015.
 */
@RestController
@RequestMapping("/customer/order")
public class CustomerOrderController {
    FakeDatabase fakeDatabase = new FakeDatabase();

    //get six orders at a time for warehouse app
    @RequestMapping(value = "/pick", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    CustomerOrder getOrderToPick() {
        return WarehouseBrain.getWarehouseBrain().getNextCustomerOrder();
    }

    //get a customer order by the orderNumber
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Order getOrderByOrderNumber(@RequestBody long orderNumber) {
        Order order = fakeDatabase.findCustomerOrderByOrderNumber(orderNumber);
        return order;
    }


    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public void Submit(@RequestParam("products") String products,@RequestParam("numbers") String numbers,@RequestParam("cost") String cost, @RequestParam("customer") String customer) {
        List<String> productList = Arrays.asList(products.split(","));
        List<String> numberListString = Arrays.asList(products.split(","));
        int totalPrice = Integer.parseInt(cost);
        List<Integer> numberOfProduct = new ArrayList<Integer>();
        for(String s : numberListString) numberOfProduct.add(Integer.valueOf(s));

    }

    //dispatch a customer order
    @RequestMapping(value = "/dispatched", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> orderDispatched(@RequestBody String[] orderNumArray) {

        try{
            long orderNumber = Long.parseLong(orderNumArray[0]);
            //get order from DB
            Order order = null;
            setProductsAsDispatched(orderNumArray, order);
            //Daves class to send text
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    public void setProductsAsDispatched(String[] orderNumArray, Order order){
        Product product = null;
        for(int i = 1; i < orderNumArray.length - 1; i+=2){
            int productID = Integer.parseInt(orderNumArray[i]);
            int quantity = Integer.parseInt(orderNumArray[i+1]);
            //get product from DB
            //Product product = db.getProduct(productID);
            //order.setProductDispatched();
        }
    }

    //dispatch a customer order
    @RequestMapping(value = "/dispatched", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> orderDispatched(@RequestBody String orderNum) {
        try{
            long orderNumber = Long.parseLong(orderNum);
            //*********get order from DB by orderNum*************************
            Order order = customerOrderService.findByOrderNumber(orderNumber);
            Map<Product, Integer> productsOrdered = order.getProductsOrdered();
            for (Map.Entry<Product, Integer> productOrdered : productsOrdered.entrySet()) {
                order.setProductDispatched(productOrdered.getKey(), productOrdered.getValue());
            }
            //Daves class to send text
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}

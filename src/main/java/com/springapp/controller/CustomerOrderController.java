package com.springapp.controller;

import com.springapp.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;


/**
 * Created by Jo on 28/09/2015.
 */
@RestController
@RequestMapping("/customer/order")
public class CustomerOrderController {
    FakeDatabase fakeDatabase = new FakeDatabase();

    //DONE
    //get one order for warehouse app
    @RequestMapping(value = "/pick", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Order getOrderToPick() {
        return WarehouseBrain.getWarehouseBrain().getNextCustomerOrder();
    }

    //DONE
    //get a customer order by the orderNumber
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Order getOrderByOrderNumber(@RequestBody long orderNumber) {
        Order order = fakeDatabase.findCustomerOrderByOrderNumber(orderNumber);
        return order;
    }

    //JAKES JSON STRING -> NOT WORKING BUT COMPLETE
    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public void Submit(@RequestParam("products") String products,@RequestParam("numbers") String numbers,@RequestParam("cost") String cost, @RequestParam("customer") String customerId) {
        List<Integer> productIDs = splitStringAndReturnIntList(products);
        List<Integer> numberOfProductToOrder = splitStringAndReturnIntList(numbers);
        Map<Product, Integer> productsToOrder = addProductsAndQuantitiesToMap(productIDs, numberOfProductToOrder);
        BigDecimal totalCost = new BigDecimal(Integer.parseInt(cost));
        Customer customer = fakeDatabase.getCustomer(Integer.parseInt(customerId));
        Order order = new CustomerOrder(productsToOrder, totalCost, customer);
        fakeDatabase.addCustomerOrder(order);
        WarehouseBrain.getWarehouseBrain().addCustomerOrder(order);
    }

    public Map<Product, Integer> addProductsAndQuantitiesToMap(List<Integer> productIDs, List<Integer> numberOfProductToOrder){
        Map<Product, Integer> productIntegerMap = new HashMap<Product, Integer>();
        Product product;
        int productId;
        int quantity;
        for(int i = 0; i < productIDs.size(); i++){
            productId = productIDs.get(i);
            product = fakeDatabase.getProduct(productId);
            quantity = numberOfProductToOrder.get(i);
            productIntegerMap.put(product, quantity);
        }
        return productIntegerMap;
    }

    public List<Integer> splitStringAndReturnIntList(String string){
        List<Integer> listToReturn = new ArrayList<Integer>();
        List<String> stringList = Arrays.asList(string.split(","));
        for (String s : stringList) listToReturn.add(Integer.valueOf(s));
        return listToReturn;
    }

    //dispatch a customer order
    @RequestMapping(value = "/dispatched/errors", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
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

    //COMPLETE
    //dispatch a customer order
    @RequestMapping(value = "/dispatched", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public @ResponseBody
    String orderDispatchedAllOK(@RequestBody String[] orderNum) {
        try{
            long orderNumber = Long.parseLong(orderNum[0]);
            Order order = fakeDatabase.findCustomerOrderByOrderNumber(orderNumber);
            Map<Product, Integer> productsOrdered = order.getProductsOrdered();
            for (Map.Entry<Product, Integer> productOrdered : productsOrdered.entrySet()) {
                order.setProductDispatched(productOrdered.getKey(), productOrdered.getValue());
            }
            //Daves class to send text
            return "OK";
        }catch(Exception ex){
            return "ERROR";
        }
    }
}

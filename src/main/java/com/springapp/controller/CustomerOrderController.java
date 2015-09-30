package com.springapp.controller;

import com.springapp.model.*;
import com.springapp.service.CustomerOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Jo on 28/09/2015.
 */
@RestController
@RequestMapping("/customer/order")
public class CustomerOrderController {
    CustomerOrderService customerOrderService;

//    @RequestMapping(path = "/get/six", method = RequestMethod.GET)
//    public @ResponseBody
//    List<CustomerOrder> getSixOrders() {
//        return WarehouseBrain.getWarehouseBrain().getAndRemoveCustomerOrders(6);
//    }

    //get six orders at a time for warehouse app
    @RequestMapping(value = "/pick", method = RequestMethod.GET, produces = "application/json")//, produces = "application/json")
    public @ResponseBody
    Order getOrderToPick() {
        Product product1 = new ProductImpl(1, 2, "productCode", "String name", "String description", new BigDecimal(2.00), "String imageUrl");
        Product product2 = new ProductImpl(2, 2, "productCode", "Gnome", "String description", new BigDecimal(2.00), "String imageUrl");
        Product product3 = new ProductImpl(3, 2, "productCode", "Remote", "String description", new BigDecimal(2.00), "String imageUrl");

        Map<Product, Integer> productsOrdered = new HashMap<Product, Integer>();
        productsOrdered.put(product1, 10);
        productsOrdered.put(product2, 20);
        productsOrdered.put(product3, 30);

        Map<Product, Integer> productsOrdered2 = new HashMap<Product, Integer>();
        productsOrdered.put(product1, 100);
        productsOrdered.put(product2, 200);
        productsOrdered.put(product3, 300);

        Customer customer = new CustomerImpl();

        CustomerOrder order = new CustomerOrder(productsOrdered, new BigDecimal(10.00), customer);
        CustomerOrder order2 = new CustomerOrder(productsOrdered2, new BigDecimal(50.00), customer);

        List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
        orders.add(order);
        orders.add(order2);

        order.setProductDispatched(product1, 5);

        //return WarehouseBrain.getWarehouseBrain().getAndRemoveCustomerOrders(6);
        //int i = 0;
        String orderNum;
        Map<Product, Integer> products;
        String customerName;
        String customerAddress;
        String jsonProducts;
        //ObjectMapper mapper = new ObjectMapper();


//        JSONObject SendObject = new JSONObject();
//        JSONObject feedObject = new JSONObject();
//        JSONArray sendArray = new JSONArray();
//        for(CustomerOrder co: orders) {
//            //i++;
//            orderNum = String.valueOf(co.getOrderNumber());
//            products = co.getProductsOrdered();
//            customerName = co.getCustomer().getTitleAndFullName();
//            customerAddress = co.getCustomer().getAddress();
//            try {
//                jsonProducts = new ObjectMapper().writeValueAsString(products);
//
//                feedObject.put("OrderNumber", orderNum);
//                feedObject.put("Products", products);
//                feedObject.put("CustomerName", customerName);
//                feedObject.put("CustomerAddress", customerAddress);
//                SendObject.put("Products", feedObject);
//                sendArray.put(i, SendObject);
//
//            //} catch (JsonProcessingException e) {
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

//        Map<String, String> jsonToReturn = new HashMap<String, String>();
//        for(CustomerOrder co: orders) {
//            //i++;
//            orderNum = String.valueOf(co.getOrderNumber());
//            products = co.getProductsOrdered();
//            customerName = co.getCustomer().getTitleAndFullName();
//            customerAddress = co.getCustomer().getAddress();
//            try {
//                //jsonProducts = mapper.writeValueAsString(products);
//                jsonToReturn.put("OrderNumber", orderNum);
//                //jsonToReturn.put("Products", jsonProducts);
//                jsonToReturn.put("CustomerName", customerName);
//                jsonToReturn.put("CustomerAddress", customerAddress);
//                //} catch (JsonProcessingException e) {
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        //JSONObject obj = new JSONObject(jsonToReturn);
        //String jsonObject = JSONObject.valueToString(jsonToReturn);
        //return jsonObject;
        return order;
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
    @RequestMapping(value = "/dispatched/errors", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> orderNotFullyDispatched(@RequestBody String[] orderNumArray) {

        try{
            long orderNumber = Long.parseLong(orderNumArray[0]);
            //get order from DB
            Order order = null;
            Product product = null;
            for(int i = 1; i < orderNumArray.length - 1; i+=2){
                int productID = Integer.parseInt(orderNumArray[i]);
                int quantity = Integer.parseInt(orderNumArray[i+1]);
                //get product from DB
                //order.setProductDispatched();
            }


            //Daves class to send text
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }


    }

    //dispatch a customer order
    @RequestMapping(value = "/dispatched", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> orderDispatched(@RequestBody String[] orderNumArray) {

        try{
            long orderNumber = Long.parseLong(orderNumArray[0]);
            //get order from DB
            Order order = null;
            Product product = null;
            for(int i = 1; i < orderNumArray.length - 1; i+=2){
                int productID = Integer.parseInt(orderNumArray[i]);
                int quantity = Integer.parseInt(orderNumArray[i+1]);
                //get product from DB
                //order.setProductDispatched();
            }


            //Daves class to send text
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }


    }

}

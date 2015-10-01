package com.springapp.controller;

import com.springapp.model.CustomerOrder;
import com.springapp.model.Order;
import com.springapp.model.Product;
import com.springapp.model.WarehouseBrain;
import com.springapp.service.CustomerOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/pick", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    CustomerOrder getOrderToPick() {
        return WarehouseBrain.getWarehouseBrain().getNextCustomerOrder();
    }

    //get a customer order by the orderNumber
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Order getOrderByOrderNumber(@RequestBody long orderNumber) {
        Order order = customerOrderService.findByOrderNumber(orderNumber);
        return order;
    }


    //place a customer order
    @RequestMapping(value = "/place", method = RequestMethod.POST, consumes = "application/json")
    //public @ResponseBody void placeOrder(@RequestBody String[] order) {
    public String placeOrder(@RequestParam(value="myArray") String[] parameters){
        //WarehouseBrain.getWarehouseBrain().addCustomerOrder(order);
        //customerOrderService.persist(order);
        //return oks
        return "";
    }


    /*
    @RequestMapping("/place")
    public class placeOrder {
        @RequestMapping(method = RequestMethod.POST)
        public @ResponseBody
        Cart add(HttpServletRequest request, HttpServletResponse response)
                throws Exception {

            Cart cart = new Cart();

            String[] products = request.getParameter("products");
            String[] numbers = request.getParameter("numberOfProducts");
            String totalPrice = request.getParameter("totPrice");

            cart.setProducts(products);
            cart.setCustomer("guest");
            cart.setQuantities(numbers);
            cart.setTotalPrice(totalPrice);
        }
    }
    */

    //dispatch a customer order
    @RequestMapping(value = "/dispatched/errors", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> orderNotFullyDispatched(@RequestBody String[] orderNumArray) {

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

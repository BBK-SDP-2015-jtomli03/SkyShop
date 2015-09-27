package com.springapp.controller;

import com.springapp.model.Supplier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jo on 27/09/2015.
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    //SupplierService supplierService = new SupplierService();

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public void addSuppliers() {
        List<Supplier> suppliers = new ArrayList<Supplier>();
        //supplierService.save(suppliers);
        //http OK
    }
}

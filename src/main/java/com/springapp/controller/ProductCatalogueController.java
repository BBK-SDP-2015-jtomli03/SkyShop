package com.springapp.controller;

import com.springapp.model.ProductCatalogue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Jo on 28/09/2015.
 */
@Controller
@RequestMapping("/catalogue")
public class ProductCatalogueController {

    @RequestMapping(path = "/get/products", method = RequestMethod.GET)
    public ModelAndView getProducts() {
        ModelAndView model = new ModelAndView("index");
		model.addObject("products", ProductCatalogue.getCatalogue().getProducts());
        return model;
    }
}

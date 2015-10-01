package com.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jo on 27/09/2015.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(method = RequestMethod.GET)
    public String printAdminHomePage() {
        return "admin";
    }
}

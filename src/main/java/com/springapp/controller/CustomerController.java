package com.springapp.controller;

/**
 * Created by jat40 on 29/09/15.
 */
import com.springapp.model.CustomerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView display() {
        return new ModelAndView("index", "command", new CustomerImpl());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("SpringWeb")CustomerImpl newUser,
                             ModelMap model) {
        model.addAttribute("firstName", newUser.getForename());

        return "test";
    }

}

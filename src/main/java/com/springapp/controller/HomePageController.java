package com.springapp.controller;

import com.springapp.model.Cart;
import com.springapp.model.CustomerOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomePageController {

	@RequestMapping(method = RequestMethod.GET)
	public String printHomePage() {
		return "index";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String printLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/account", method = RequestMethod.GET)
	public String printAccountPage() {
		return "account";
	}

	@RequestMapping(path = "/product", method = RequestMethod.GET)
	public String printProduct() {
		return "product";
	}

	@RequestMapping(path = "/show_all", method = RequestMethod.GET)
	public String printAllProducts() {
		return "show_all";
	}

	@RequestMapping(path = "/basket", method = RequestMethod.GET)
	public String printBasket(Model model) {
		model.addAttribute("order", new CustomerOrder());
		return "basket";
	}

	@RequestMapping(value = "/get/cart", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Cart getOrderByOrderNumber() {
		Cart cart = new Cart();
		return cart;
	}
}
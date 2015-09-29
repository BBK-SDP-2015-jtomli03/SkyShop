package com.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String printBasket() {
		return "basket";
	}
}
package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class responsible for creating and fetching products based on location
 * 
 * @author Vaishali
 * @version 1.0
 */
@Controller
@RequestMapping("/app")
public class HomeController {

	@RequestMapping("/productSelection")
	public String pageNgResource() {
		//TODO : Fetch
 		return "productSelection";
 	}
}

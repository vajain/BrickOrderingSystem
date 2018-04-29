package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Product;
import com.shop.service.ShoppingAppService;
import com.shop.util.ShoppingAppConstants;


/**
 * Controller class responsible for fetching products for product detail page
 * 
 * @author Vaishali
 * @version 1.0
 */
@RestController
public class ShoppingAppController {

	private static final Logger logger = LoggerFactory.getLogger(ShoppingAppController.class);

	@Autowired
	private ShoppingAppService shoppingAppService;
	
	/**
	 * This service fetches the customer's location based on customer id from database
	 */
	@RequestMapping(value = "/getLocation/{customerId}", method = RequestMethod.GET, produces = "application/json")
	public int getCustomerLocation(@PathVariable("customerId") int customerId) {
		//TODO: Implementation 
		return 3;
	}

	/**
	 * This service fetches products based on location
	 */
	@RequestMapping(value = "/getProducts/{locationId}", method = RequestMethod.GET, produces = "application/json")
	public List<Product> getCatalogue(@PathVariable("locationId") int locationId) {
		List<Product> product = new ArrayList<Product>();
		product = shoppingAppService.getProducts(locationId);
		product.add(new Product(0, 0, ShoppingAppConstants.SKY_NEWS_PRODUCT, ShoppingAppConstants.NEWS_CATEGORY));
		product.add(new Product(0, 0, ShoppingAppConstants.SKY_SPORTS_NEWS_PRODUCT, ShoppingAppConstants.NEWS_CATEGORY));
		logger.info("Products fetched successfully");
		return product;
	}
}

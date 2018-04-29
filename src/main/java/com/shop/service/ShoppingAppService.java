package com.shop.service;

import java.util.List;

import com.shop.model.Product;

/**
 * Service interface holding methods for fetching products for specific locations.
 * 
 * @author Vaishali
 * @version 1.0
 */
public interface ShoppingAppService {
	
	/**
	 * This method fetches products available for a location.
	 */
	public List<Product> getProducts(int locationId);
}

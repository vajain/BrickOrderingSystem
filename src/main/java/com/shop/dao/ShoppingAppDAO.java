package com.shop.dao;

import java.util.List;

import com.shop.model.Product;

/**
 * Dao layer interface holding methods for performing product detail specific tasks interacting with database.
 * 
 * @author Vaishali
 * @version 1.0
 */
public interface ShoppingAppDAO {
	
	/**
	 * This method fetches products available for a location.
	 */
	public List<Product> getProducts(int locationId);
	
}

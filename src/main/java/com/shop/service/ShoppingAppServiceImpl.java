package com.shop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.ShoppingAppDAO;
import com.shop.model.Product;

/**
 * Service implementation class holding implementation of methods for fetching products for specific location.
 * 
 * @author Vaishali
 * @version 1.0
 */
@Service
@Transactional
public class ShoppingAppServiceImpl implements ShoppingAppService {
	 
	@Autowired
	private ShoppingAppDAO shoppingAppDAO;

	@Override
	public List<Product> getProducts(int locationId){
		return shoppingAppDAO.getProducts(locationId);
	}

}

package com.shop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.model.Product;

/**
 * Dao layer implementation Class for performing product detail specific info
 * interacting with database.
 * 
 * @author Vaishali
 * @version 1.0
 */
@Repository
public class ShoppingAppDAOImpl implements ShoppingAppDAO {

	private static final Logger logger = LoggerFactory.getLogger(ShoppingAppDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts(int locationId) {
		List<Product> productList = null;
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Product pr where pr.locationId=:locationId");
		query.setInteger("locationId", locationId);
		productList = query.list();
		logger.info("ProductList fetched successfully.");
		return productList;
	}
}

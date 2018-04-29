package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * This is entity class for product table.
 * 
 * @author Vaishali
 * @version 1.0
 */
@Entity
@Table(name = "PRODUCTS")
@Proxy(lazy = false) 
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "location_id")
	private int locationId;


	@Column(name = "product")
	private String product;


	@Column(name = "category")
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product(int id, int locationId, String product, String category) {
		super();
		this.id = id;
		this.locationId = locationId;
		this.product = product;
		this.category = category;
	}
	
	public Product (){
	}

	public Product(String product, String category) {
		super();
		this.product = product;
		this.category = category;
	}
	
	
}

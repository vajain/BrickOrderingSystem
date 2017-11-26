package com.bos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This is entity class for order_detail table.
 * 
 * @author Vaishali
 * @version 1.0
 */
@Entity
@Table(name = "ORDER_DETAIL")
@Proxy(lazy = false) 
public class OrderDetail {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Column(name = "number_of_bricks")
	private Integer numberOfBricks;

	@JsonIgnore
	@Column(name = "person_id")
	private String personId;

	@JsonIgnore
	@Column(name = "order_date")
	private Date orderDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Integer getNumberOfBricks() {
		return numberOfBricks;
	}

	public void setNumberOfBricks(Integer numberOfBricks) {
		this.numberOfBricks = numberOfBricks;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderDetail() {
		super();
	}
	
	public OrderDetail(int orderId, Integer numberOfBricks) {
		super();
		this.orderId = orderId;
		this.numberOfBricks = numberOfBricks;
	}
	
}

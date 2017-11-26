package com.bos.vo;

import java.util.Date;

/**
 * This is VO class for OrderDetail.java
 * 
 * @author Vaishali
 * @version 1.0
 */
public class OrderDetailVO {

	private int orderId;

	private Integer numberOfBricks;

	private String personId;

	private Date orderDate;
	
	public OrderDetailVO(int orderId, Integer numberOfBricks, String personId, Date orderDate) {
		super();
		this.orderId = orderId;
		this.numberOfBricks = numberOfBricks;
		this.personId = personId;
		this.orderDate = orderDate;
	}

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
}

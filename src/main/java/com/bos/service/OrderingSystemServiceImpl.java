package com.bos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.dao.OrderingSystemDAO;
import com.bos.model.OrderDetail;

/**
 * Service implementation class holding implementation of methods for performing order details specific tasks.
 * 
 * @author Vaishali
 * @version 1.0
 */
@Service
@Transactional
public class OrderingSystemServiceImpl implements OrderingSystemService {
	 
	@Autowired
	private OrderingSystemDAO orderingSystemDAO;

	@Override
	public OrderDetail createOrder(int numberOfItems)  {
		return orderingSystemDAO.createOrder(numberOfItems);
	}

	@Override
	public List<OrderDetail> getOrders() {
		return orderingSystemDAO.getOrders();
	}

	@Override
	public OrderDetail getOrder(int orderId) 	{
		return orderingSystemDAO.getOrder(orderId);
	}

}

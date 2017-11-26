package com.bos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.exception.OrderNotFoundException;
import com.bos.model.OrderDetail;
import com.bos.service.OrderingSystemService;

/**
 * Controller class responsible for creating and fetching brick orders
 * 
 * @author Vaishali
 * @version 1.0
 */
@RestController
public class OrderingSystemController {

	private static final Logger logger = LoggerFactory.getLogger(OrderingSystemController.class);

	@Autowired
	private OrderingSystemService orderingSystemService;

	/**
	 * This method creates new order 
	 * @param OrderDetail details of order to be saved    
	 * @return OrderDetail saved order details
	 */
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public OrderDetail createOrder(@RequestBody OrderDetail orderDetail) {

		orderDetail = orderingSystemService.createOrder(orderDetail.getNumberOfBricks());

		logger.info("Order created successfully");
		return orderDetail;

	}

	/**
	 * This method fetches order details of particular order.
	 * @param orderId
	 *            reference no. of particular order whose detail is to be fetched
	 * 
	 * @return OrderDetail object holding order details.
	 * @throws OrderNotFoundException 
	 */
	@RequestMapping(value = "/getOrder/{orderId}", method = RequestMethod.GET, produces = "application/json")
	public OrderDetail getOrder(@PathVariable("orderId") int orderId) throws OrderNotFoundException {
		OrderDetail orderDetail = orderingSystemService.getOrder(orderId);
		if(orderDetail == null) {
			logger.info("No order detail found with given id");
			throw new OrderNotFoundException("Order not found with given id");
		}
		logger.info("Order detail fetched successfully");
		return orderDetail;
	}

	/**
	 * This method fetches order details.
	 * @return List of order detail
	 */
	@RequestMapping(value = "/getOrders", method = RequestMethod.GET, produces = "application/json")
	public List<OrderDetail> getOrders() {
		List<OrderDetail>  orderDetailList = orderingSystemService.getOrders();
		logger.info("Orders list fetched successfully");
		return orderDetailList;
	}

}

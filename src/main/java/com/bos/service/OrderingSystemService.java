package com.bos.service;

import java.util.List;

import com.bos.model.OrderDetail;

/**
 * Service interface holding methods for performing order detail specific tasks.
 * 
 * @author Vaishali
 * @version 1.0
 */
public interface OrderingSystemService {
	
	/**
	 * This method saves order detail of a particular order.
	 * 
	 * @exception OrderSystemException throws this exception in case any exception is caught during saving order detail.
	 * @return  OrderDetail Order detail of the order saved
	 */
	public OrderDetail createOrder(int numberOfItems) ;
	
	/**
	 * This method fetches order detail of a particular order.
	 * 
	 * @exception OrderSystemException throws this exception in case any exception is caught during list fetching.
	 * @return  OrderDetail Detail of particular order
	 */
	public OrderDetail getOrder(int orderId) ;
	
	/**
	 * This method fetches order detail list.
	 * 
	 * @exception OrderSystemException throws this exception in case any exception is caught during list fetching.
	 * @return  List<OrderDetail> List of order detail.
	 */
	public List<OrderDetail>getOrders() ;

}

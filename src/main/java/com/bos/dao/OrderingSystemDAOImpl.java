package com.bos.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bos.model.OrderDetail;

/**
 * Dao layer implementation Class for performing order detail specific tasks
 * interacting with database.
 * 
 * @author Vaishali
 * @version 1.0
 */
@Repository
public class OrderingSystemDAOImpl implements OrderingSystemDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderingSystemDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public OrderDetail createOrder(int numberOfItems) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setNumberOfBricks(numberOfItems);
		Session session = this.sessionFactory.openSession();
		session.save(orderDetail);

		logger.info("Order Detail is saved successfully.");
		return orderDetail;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public OrderDetail getOrder(int orderId) {
		OrderDetail orderDetail = null;
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from OrderDetail od where od.orderId=:orderId");
		query.setParameter("orderId", orderId);

		for (Iterator it = query.iterate(); it.hasNext();) {
			orderDetail = (OrderDetail) it.next();
		}
		logger.info("Order Detail is fetched successfully.");
		return orderDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> getOrders() {
		List<OrderDetail> orderDetailList = null;
		Session session = this.sessionFactory.openSession();
		orderDetailList = session.createQuery("from OrderDetail").list();
		logger.info("Order Detail List fetched successfully.");
		return orderDetailList;

	}
}

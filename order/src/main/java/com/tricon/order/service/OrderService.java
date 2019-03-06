package com.tricon.order.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tricon.order.model.Order;


public interface OrderService {
	public List<Order> getAllOrder();
	public Optional<Order> getOrder(Long id);
	public Order createOrder(Order order);
	public Order updateOrder(Order order);
	public void deleteOrder(Long id);
	List<Order> getOrderDetails(Long id, Date fromDate, Date toDate);

}

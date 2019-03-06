package com.tricon.order.daoImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tricon.order.dao.OrderRepository;
import com.tricon.order.dao.OrderRepositoryCustom;
import com.tricon.order.model.Order;


@Repository
public class OrderDaoImpl implements OrderRepositoryCustom{
	
	@Autowired
	OrderRepository orderRepository;

	public Order createOrder(Order Order) {
		return orderRepository.insert(Order);
	}
	
	public Order updateOrder(Order Order) {
		return orderRepository.save(Order);
	}
	
	public List<Order> getAllOrder(){
		return orderRepository.findAll();
	}
	
	public Optional<Order> getOrder(Long id){
		return orderRepository.findById(id);
	}
	
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public List<Order> getOrderDetails(Long id, Date fromDate, Date toDate) {
		return orderRepository.getOrderDetails(id, fromDate, toDate);
		
	}

	



}

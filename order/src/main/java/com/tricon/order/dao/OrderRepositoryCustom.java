package com.tricon.order.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import com.tricon.order.model.Order;

public interface OrderRepositoryCustom {
	
	@Query("{ 'customerId': ?0,  'orderTime': {$gte:?1,$lte:?2}}")
	public List<Order> getOrderDetails(Long id, Date fromDate, Date toDate);
}

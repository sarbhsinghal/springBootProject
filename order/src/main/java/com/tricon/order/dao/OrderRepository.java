package com.tricon.order.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tricon.order.model.Order;

public interface OrderRepository extends MongoRepository<Order, Long>,OrderRepositoryCustom{

}

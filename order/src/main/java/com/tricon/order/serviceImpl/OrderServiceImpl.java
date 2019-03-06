package com.tricon.order.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tricon.order.daoImpl.OrderDaoImpl;
import com.tricon.order.model.Order;
import com.tricon.order.model.OrderedProduct;
import com.tricon.order.service.OrderService;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDaoImpl orderDaoImpl;

	@Override
	public List<Order> getAllOrder() {
		return orderDaoImpl.getAllOrder();
	}

	@Override
	@Transactional
	public Order createOrder(Order order) {
		ListIterator<OrderedProduct> iterator = order.getOrderedItems().listIterator();
		while (iterator.hasNext()) {
			OrderedProduct o = iterator.next();
			o.setTotal(o.getAmount() + o.getTax().getCGST() + o.getTax().getSGST());
		}
		return orderDaoImpl.createOrder(order);
	}

	@Override
	@Transactional
	public Order updateOrder(Order order) {
		ListIterator<OrderedProduct> iterator = order.getOrderedItems().listIterator();
		while (iterator.hasNext()) {
			OrderedProduct o = iterator.next();
			o.setTotal(o.getAmount() + o.getTax().getCGST() + o.getTax().getSGST());
		}
		return orderDaoImpl.updateOrder(order);
	}

	@Override
	@Transactional
	public void deleteOrder(Long id) {
		orderDaoImpl.deleteOrder(id);

	}

	@Override
	public List<Order> getOrderDetails(Long id, Date fromDate, Date toDate) {

		return orderDaoImpl.getOrderDetails(id, fromDate, toDate);
	}

	@Override
	public Optional<Order> getOrder(Long id) {
		return orderDaoImpl.getOrder(id);
	}

}

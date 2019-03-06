package com.tricon.order.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tricon.order.model.Order;
import com.tricon.order.serviceImpl.OrderServiceImpl;


@RestController
@RequestMapping("/tricon")
@Validated
public class OrderController {
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@PostMapping("/order")
	public Order createOrder(@Valid @RequestBody Order order) {
		return orderServiceImpl.createOrder(order);
	}
	@PutMapping("/order")
	public Order updatetOrder(@Valid @RequestBody Order order) {
		return orderServiceImpl.updateOrder(order);
	}
	
	@GetMapping("/order")
	public List<Order> getAllOrder(){
		return orderServiceImpl.getAllOrder();
	}
	@GetMapping("/order/{id}")
	public Optional<Order> getOrder(@Valid @Min(1) @Max(50000) @PathVariable Long id){
		return orderServiceImpl.getOrder(id);
	}
	
	@DeleteMapping("/order/{id}")
	public void deleteOrder(@Valid @Min(1) @Max(50000) @PathVariable Long id) {
		orderServiceImpl.deleteOrder(id);
	}
	
	@GetMapping ("/order/myorder/{id}")
	public List<Order> getOrderDetails(@PathVariable Long id,@RequestParam(value = "fromDate", required = false) String fromDate,@RequestParam(value = "toDate", required = false) String toDate) throws ParseException{
		return orderServiceImpl.getOrderDetails(id,new SimpleDateFormat("dd/MM/yyyy").parse(fromDate)  ,new SimpleDateFormat("dd/MM/yyyy").parse(toDate));
	}

	}




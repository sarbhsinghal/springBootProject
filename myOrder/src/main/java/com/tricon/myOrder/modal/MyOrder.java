package com.tricon.myOrder.modal;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tricon.myOrder.pojoClasses.Customer;

@Component
public class MyOrder {
	
	private Customer customer_details;
	private List<Orders> orders;
	
	public Customer getCustomer_details() {
		return customer_details;
	}
	public void setCustomer_details(Customer customer_details) {
		this.customer_details = customer_details;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "MyOrder [customer_details=" + customer_details + ", orders=" + orders + "]";
	}
	public MyOrder() {
		super();
	}
	public MyOrder(Customer customer_details, List<Orders> orders) {
		super();
		this.customer_details = customer_details;
		this.orders = orders;
	}

}

package com.tricon.myOrder.pojoClasses;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Order {
	
	@Min(1) @Max(50000) @NotNull
	private Long id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm")
	@NotNull
	private Date orderTime;
	@Min(1) @Max(50000) @NotNull
	private Long customerId;
	@NotNull @Size(min=4,max=15)
	private String paymentMode;
	@Valid
	private List<OrderedProduct> orderedItems;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public List<OrderedProduct> getOrderedItems() {
		return orderedItems;
	}
	public void setOrderedItems(List<OrderedProduct> orderedItems) {
		this.orderedItems = orderedItems;
	}
	public Order(Long id, Date orderTime, Long customerId, String paymentMode, List<OrderedProduct> orderedItems) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.customerId = customerId;
		this.paymentMode = paymentMode;
		this.orderedItems = orderedItems;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTime=" + orderTime + ", customerId=" + customerId + ", paymentMode="
				+ paymentMode + ", orderedItems=" + orderedItems + "]";
	}
	
	
}

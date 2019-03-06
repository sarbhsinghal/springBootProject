package com.tricon.myOrder.modal;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Orders {
	
	private Long orderId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm")
	private Date orderTime;
	private String paymentMode;
	
	private List<MyOrderedProducts> myOrderedProducts;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public List<MyOrderedProducts> getMyOrderedProducts() {
		return myOrderedProducts;
	}
	public void setMyOrderedProducts(List<MyOrderedProducts> myOrderedProducts) {
		this.myOrderedProducts = myOrderedProducts;
	}
	
	
	
	public Orders(Long orderId, Date orderTime, String paymentMode, List<MyOrderedProducts> myOrderedProducts) {
		super();
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.paymentMode = paymentMode;
		this.myOrderedProducts = myOrderedProducts;
	}
	
	public Orders(Long orderId, Date orderTime, String paymentMode) {
		super();
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.paymentMode = paymentMode;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderTime=" + orderTime + ", paymentMode=" + paymentMode
				+ ", myOrderedProducts=" + myOrderedProducts + "]";
	}
	

}

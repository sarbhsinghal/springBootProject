package com.tricon.myOrder.service;

import com.tricon.myOrder.modal.MyOrder;

public interface IMyOrderService {

	public MyOrder getCustomerProducts(Long id,String fromDate,String toDate);
}

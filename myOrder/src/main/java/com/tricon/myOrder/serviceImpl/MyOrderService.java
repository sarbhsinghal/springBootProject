package com.tricon.myOrder.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tricon.myOrder.modal.MyOrder;
import com.tricon.myOrder.restClientServiceImpl.RestClientService;
import com.tricon.myOrder.service.IMyOrderService;

@Service
public class MyOrderService implements IMyOrderService {

	@Autowired
	RestClientService restClientService;
	
	@Override
	public MyOrder getCustomerProducts(Long id, String fromDate, String toDate) {
		return restClientService.getCustomerProducts(id, fromDate, toDate);
	}

	

}

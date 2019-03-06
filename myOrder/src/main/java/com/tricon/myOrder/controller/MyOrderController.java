package com.tricon.myOrder.controller;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tricon.myOrder.modal.MyOrder;
import com.tricon.myOrder.restClient.IRestClientService;
import com.tricon.myOrder.serviceImpl.MyOrderService;

@RestController
@RequestMapping("/tricon/myorder")
public class MyOrderController {
	@Autowired
	MyOrderService myOrderService;
	
	@GetMapping("/{id}")
	public MyOrder getOrders(@PathVariable Long id,@RequestParam(value = "fromDate", required = false) String fromDate,@RequestParam(value = "toDate", required = false) String toDate) throws ParseException, java.text.ParseException{
		
		return myOrderService.getCustomerProducts(id,fromDate,toDate  );
	}

}

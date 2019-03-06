package com.tricon.myOrder.restClient;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tricon.myOrder.modal.MyOrder;
import com.tricon.myOrder.pojoClasses.Customer;
import com.tricon.myOrder.pojoClasses.Order;
import com.tricon.myOrder.pojoClasses.Product;

@Service
public interface IRestClientService {

	public MyOrder getCustomerProducts(Long id,String fromDate,String toDate);
	public Customer getCustomerDetails(Long id);
	public List<Order> getOrderDetails(Long id,String fromDate,String toDate);
	public Product getProductDetails(Long id);


}

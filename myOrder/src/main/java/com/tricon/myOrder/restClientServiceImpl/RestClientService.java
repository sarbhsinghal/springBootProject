package com.tricon.myOrder.restClientServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tricon.myOrder.modal.MyOrder;
import com.tricon.myOrder.modal.MyOrderedProducts;
import com.tricon.myOrder.modal.Orders;
import com.tricon.myOrder.pojoClasses.Customer;
import com.tricon.myOrder.pojoClasses.Order;
import com.tricon.myOrder.pojoClasses.OrderedProduct;
import com.tricon.myOrder.pojoClasses.Product;
import com.tricon.myOrder.restClient.IRestClientService;

@Service
public class RestClientService implements IRestClientService {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Override
	public MyOrder getCustomerProducts(Long id, String fromDate, String toDate) {
		MyOrder myorder = new MyOrder();
		List<Orders> orders_list = new ArrayList<>();

		myorder.setCustomer_details(getCustomerDetails(id));

		Iterator<Order> iterator = getOrderDetails(id, fromDate, toDate).iterator();

		while (iterator.hasNext()) {
			Order iterator_order_item = iterator.next();
			Orders myeachorder = new Orders(iterator_order_item.getId(), iterator_order_item.getOrderTime(),
					iterator_order_item.getPaymentMode());

			List<MyOrderedProducts> ordered_product_details = new ArrayList<>();
			Iterator<OrderedProduct> iterator2 = iterator_order_item.getOrderedItems().iterator();
			while (iterator2.hasNext()) {
				OrderedProduct iterator2_orderProduct_item = iterator2.next();

				MyOrderedProducts my_ordered_product_details = new MyOrderedProducts(
						getProductDetails(iterator_order_item.getId()), iterator2_orderProduct_item.getAmount(),
						iterator2_orderProduct_item.getCurrency(), iterator2_orderProduct_item.getTax(),
						iterator2_orderProduct_item.getTotal(), iterator2_orderProduct_item.getsDelivery(),
						iterator2_orderProduct_item.getaDelivery(), iterator2_orderProduct_item.getsShipping(),
						iterator2_orderProduct_item.getaShipping());
				ordered_product_details.add(my_ordered_product_details);
			}
			myeachorder.setMyOrderedProducts(ordered_product_details);
			orders_list.add(myeachorder);
		}
		myorder.setOrders(orders_list);
		return myorder;
	}
	
	

	@Override
	public Customer getCustomerDetails(Long id) {

		String url = "http://CUSTOMER-SERVICE/tricon/customer/";
		ResponseEntity<Customer> result = restTemplate.exchange(url + id, HttpMethod.GET, null, Customer.class);
		return result.getBody();
	}
	
	

	@Override
	public List<Order> getOrderDetails(Long id, String fromDate, String toDate) {
		String url = "http://ORDER-SERVICE/tricon/order/myorder/" + id + "/?fromDate=" + fromDate + "&toDate=" + toDate;

		ResponseEntity<List<Order>> result = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Order>>() {
				});
		return result.getBody();
	}
	
	

	@Override
	public Product getProductDetails(Long id) {

		String URL = "http://PRODUCT-SERVICE/tricon/product/";
		ResponseEntity<Product> result = restTemplate.exchange(URL + id, HttpMethod.GET, null, Product.class);
		return result.getBody();
	}

}

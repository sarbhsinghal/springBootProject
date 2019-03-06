package com.tricon.customer.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tricon.customer.daoImpl.CustomerDaoImpl;
import com.tricon.customer.modal.Customer;
import com.tricon.customer.service.CustomerService;

@Service
@Transactional(readOnly=true)
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDaoImpl customerDaoImpl;
	
	
	@Override
	
	public List<Customer> getAllCustomer() {
		return customerDaoImpl.getAllCustomer();
	}

	@Override
	public Optional<Customer> getCustomer(Long id) {
	return customerDaoImpl.getCustomer(id);
	}

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		return customerDaoImpl.createCustomer(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		return customerDaoImpl.updateCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
	 customerDaoImpl.deleteCustomer(id);
	}


	
}

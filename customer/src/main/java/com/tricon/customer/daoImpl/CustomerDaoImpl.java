package com.tricon.customer.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tricon.customer.dao.CustomerRepository;
import com.tricon.customer.modal.Customer;

@Repository
public class CustomerDaoImpl {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomer(){
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Optional<Customer> getCustomer(Long id) {
		return customerRepository.findById(id);
	}
	
	public Customer createCustomer(Customer customer) {
		Customer c= null;
		 c = customerRepository.save(customer);
		return c;
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);;
	}
	
}

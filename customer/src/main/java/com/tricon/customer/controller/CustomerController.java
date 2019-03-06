package com.tricon.customer.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricon.customer.modal.Customer;
import com.tricon.customer.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("/tricon")
@Validated
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return customerServiceImpl.getAllCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomer(@Valid @Min(1) @Max(50000) @PathVariable Long id){
		return customerServiceImpl.getCustomer(id);
	}
	
	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerServiceImpl.createCustomer(customer);
	}
	@PutMapping("/customer")
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		return customerServiceImpl.updateCustomer(customer);
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@Valid @Min(1) @Max(50000)@PathVariable Long id) {
		customerServiceImpl.deleteCustomer(id);
	}
}

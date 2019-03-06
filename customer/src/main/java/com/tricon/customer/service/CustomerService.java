package com.tricon.customer.service;

import java.util.List;
import java.util.Optional;

import com.tricon.customer.modal.Customer;

public interface CustomerService {

	/**
	 * This function returns details of all the customers
	 * @return a list of Customer Objects.
	 */
	public List<Customer> getAllCustomer();
	
	/**
	 * This function return the details of a particular Customer.
	 * @param id The CustomerId
	 * @return Customer Object
	 */
	public Optional<Customer> getCustomer(Long id);
	
	/**
	 * This function is used to create a new Customer.
	 * @param customer Takes Customer Object as parameter
	 * @return Return the customer object that is inserted in database.
	 */
	public Customer createCustomer(Customer customer);
	
	/**
	 * This function is used to update the Customer details.
	 * @param customer  Takes Customer Object as parameter
	 * @return the customer object that is updated in database.
	 */
	public Customer updateCustomer(Customer customer);
	
	/**
	 * This function is used to delete a Customer.
	 * @param id Takes Customer Id as parameter.
	 */
	public void deleteCustomer(Long id);


}

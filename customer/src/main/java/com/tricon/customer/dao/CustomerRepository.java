package com.tricon.customer.dao;

import org.springframework.data.repository.CrudRepository;

import com.tricon.customer.modal.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long>{

}

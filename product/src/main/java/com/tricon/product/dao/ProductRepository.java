package com.tricon.product.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tricon.product.modal.Product;

public interface ProductRepository extends MongoRepository<Product, Long>{

}

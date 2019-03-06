package com.tricon.product.service;

import java.util.List;
import java.util.Optional;

import com.tricon.product.modal.Product;

public interface ProductService {
	
	public List<Product> getAllProduct();
	public Optional<Product> getProduct(Long id);
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public void deleteProduct(Long id);
}

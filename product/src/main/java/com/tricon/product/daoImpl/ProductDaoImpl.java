package com.tricon.product.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tricon.product.dao.ProductRepository;
import com.tricon.product.modal.Product;

@Repository
public class ProductDaoImpl {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		return productRepository.insert(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public Optional<Product> getProduct(Long id){
		return productRepository.findById(id);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}

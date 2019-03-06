package com.tricon.product.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tricon.product.daoImpl.ProductDaoImpl;
import com.tricon.product.modal.Product;
import com.tricon.product.service.ProductService;

@Service
@Transactional(readOnly=true)
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDaoImpl productDaoImpl;

	@Override
	public List<Product> getAllProduct() {
	return productDaoImpl.getAllProduct();
	}

	@Override
	@Transactional
	public Product createProduct(Product product) {
		return productDaoImpl.createProduct(product);
		
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		return productDaoImpl.updateProduct(product);
	}

	@Override
	public Optional<Product> getProduct(Long id) {
	return productDaoImpl.getProduct(id);
	}

	@Override
	@Transactional
	public void deleteProduct(Long id) {
		productDaoImpl.deleteProduct(id);
		
	}

}

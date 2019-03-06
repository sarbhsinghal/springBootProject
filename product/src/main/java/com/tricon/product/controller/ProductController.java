package com.tricon.product.controller;

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

import com.tricon.product.modal.Product;
import com.tricon.product.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/tricon")
@Validated
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@PostMapping("/product")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productServiceImpl.createProduct(product);
	}
	@PutMapping("/product")
	public Product updatetProduct(@Valid @RequestBody Product product) {
		return productServiceImpl.updateProduct(product);
	}
	
	@GetMapping("/product")
	public List<Product> getAllProduct(){
		return productServiceImpl.getAllProduct();
	}
	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@Valid @Min(1) @Max(50000) @PathVariable Long id){
		return productServiceImpl.getProduct(id);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@Valid @Min(1) @Max(50000) @PathVariable Long id) {
		productServiceImpl.deleteProduct(id);
	}

}

package com.eduardozanela.commerce.commerce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardozanela.commerce.commerce.entity.Product;
import com.eduardozanela.commerce.commerce.repository.ProductRepository;
import com.eduardozanela.commerce.commerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private
	ProductRepository productRepository;
		
	@Override
	public Optional<Product> findProductById(String id) {
		return getProductRepository().findById(id);
	}
	
	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
}

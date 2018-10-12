package com.eduardozanela.commerce.commerce.service;

import java.util.Optional;

import com.eduardozanela.commerce.commerce.entity.Product;

public interface ProductService {
	Iterable<Product> getAllProducts();
	Optional<Product> findProductById(String id);
}

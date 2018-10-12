package com.eduardozanela.commerce.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardozanela.commerce.commerce.entity.Product;
import com.eduardozanela.commerce.commerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private
	ProductService productService;
	
	@GetMapping
	public Iterable<Product> getAllProducts(){
		return getProductService().getAllProducts();
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}

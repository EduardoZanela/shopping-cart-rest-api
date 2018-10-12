package com.eduardozanela.commerce.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardozanela.commerce.commerce.entity.CommerceItem;
import com.eduardozanela.commerce.commerce.entity.Request;
import com.eduardozanela.commerce.commerce.entity.ShoppingCart;
import com.eduardozanela.commerce.commerce.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingcart/items")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService cartService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public CommerceItem addCommerceItemToCart(@RequestBody Request request) {
		CommerceItem addCommerceItem = getCartService().addCommerceItem(request.getProductId(), request.getQuantity());
		return addCommerceItem;
	}
	
	@DeleteMapping(path="{id}")
	public void removeCommerceItemFromCart(@PathVariable String id) {
		getCartService().removeCommerceItem(id);
	}
	
	@GetMapping
	public ShoppingCart getCurrentShoppingCart() {
		return getCartService().getCart();
	}

	public ShoppingCartService getCartService() {
		return cartService;
	}

	public void setCartService(ShoppingCartService cartService) {
		this.cartService = cartService;
	}
}

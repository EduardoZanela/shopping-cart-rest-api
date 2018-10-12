package com.eduardozanela.commerce.commerce.service;

import com.eduardozanela.commerce.commerce.entity.CommerceItem;
import com.eduardozanela.commerce.commerce.entity.ShoppingCart;

public interface ShoppingCartService {
	CommerceItem addCommerceItem(String productId, int quantity);
	void removeCommerceItem(String id);
	ShoppingCart getCart();
}

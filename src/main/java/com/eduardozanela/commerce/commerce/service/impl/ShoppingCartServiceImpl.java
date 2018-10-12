package com.eduardozanela.commerce.commerce.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.eduardozanela.commerce.commerce.entity.CommerceItem;
import com.eduardozanela.commerce.commerce.entity.Product;
import com.eduardozanela.commerce.commerce.entity.ShoppingCart;
import com.eduardozanela.commerce.commerce.service.CommerceItemService;
import com.eduardozanela.commerce.commerce.service.ProductService;
import com.eduardozanela.commerce.commerce.service.ShoppingCartService;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	private CommerceItemService commerceItemService;
	
	@Autowired
	private ProductService productService;
	
	private ShoppingCart cart = new ShoppingCart();
	
	@Override
	public CommerceItem addCommerceItem(String productId, int quantity) {
		Optional<CommerceItem> filter = getCart().getItems().stream().filter(item -> item.getProductId().equals(productId)).findFirst();
		Optional<Product> product = getProductService().findProductById(productId);
		CommerceItem commerceItem = null;
		if(product.isPresent()){
				commerceItem = filter.isPresent() ? filter.get() : new CommerceItem();
				commerceItem.setQuantity(commerceItem.getQuantity()+quantity);
				commerceItem.setProductId(productId);
				commerceItem.setAmount(product.get().getPrice().multiply(new BigDecimal(commerceItem.getQuantity())));
				getCart().addOrUpdateItem(commerceItem);
				return getCommerceItemService().save(commerceItem);
		}
		return commerceItem;
	}
	
	@Override
	public void removeCommerceItem(String id) {
		CommerceItem removed = getCommerceItemService().remove(id);
		getCart().removeItem(removed);		
	}
	
	public CommerceItemService getCommerceItemService() {
		return commerceItemService;
	}

	public void setCommerceItemService(CommerceItemService commerceItemService) {
		this.commerceItemService = commerceItemService;
	}

	@Override
	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}

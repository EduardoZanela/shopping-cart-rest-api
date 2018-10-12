package com.eduardozanela.commerce.commerce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardozanela.commerce.commerce.entity.CommerceItem;
import com.eduardozanela.commerce.commerce.repository.CommerceItemRepository;
import com.eduardozanela.commerce.commerce.service.CommerceItemService;

@Service
public class CommerceItemServiceImpl implements CommerceItemService{

	@Autowired
	private CommerceItemRepository commerceItemRepository;
	
	@Override
	public CommerceItem save(CommerceItem item) {
		return getCommerceItemRepository().save(item);
	}

	@Override
	public CommerceItem remove(String id) {
		Optional<CommerceItem> findById = getCommerceItemRepository().findById(id);
		getCommerceItemRepository().deleteById(id);
		return findById.get();
	}

	@Override
	public CommerceItem findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CommerceItemRepository getCommerceItemRepository() {
		return commerceItemRepository;
	}

	public void setCommerceItemRepository(CommerceItemRepository commerceItemRepository) {
		this.commerceItemRepository = commerceItemRepository;
	}

}

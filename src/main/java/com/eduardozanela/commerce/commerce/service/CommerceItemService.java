package com.eduardozanela.commerce.commerce.service;

import com.eduardozanela.commerce.commerce.entity.CommerceItem;

public interface CommerceItemService {
	CommerceItem save(CommerceItem item);
	CommerceItem remove(String id);
	CommerceItem findById(String id);
}

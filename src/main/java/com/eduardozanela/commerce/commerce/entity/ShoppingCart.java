package com.eduardozanela.commerce.commerce.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = 1038973269215842388L;
	private List<CommerceItem> items = new ArrayList<>();
	private BigDecimal amount = new BigDecimal(0);
	
	public BigDecimal getAmount() {
		return amount.setScale(2, RoundingMode.HALF_DOWN);
	}
	private void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public List<CommerceItem> getItems() {
		return items;
	}
	public void removeItem(CommerceItem item){
		this.items.remove(item);
		recalculateAmount();
	}
	public void addOrUpdateItem(CommerceItem commerceItem) {
		int i = this.items.indexOf(commerceItem);
		if(i >= 0) {
			this.items.set(i, commerceItem);

		} else {
			this.items.add(commerceItem);
		}
		recalculateAmount();
	}
	private void recalculateAmount() {
		setAmount(new BigDecimal(0));
		this.items.stream().forEach(ci -> setAmount(getAmount().add(ci.getAmount())));
	}	
}

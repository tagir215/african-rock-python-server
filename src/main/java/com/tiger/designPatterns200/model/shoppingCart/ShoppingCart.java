package com.tiger.designPatterns200.model.shoppingCart;

import java.util.List;

import com.tiger.designPatterns200.model.component.Computer;

public interface ShoppingCart {
	public void addItem(CartItemDTO cartItem, String token);
	public void removeItem(CartItemDTO cartItem, String token);
	public void clear(String token);
	public List<Computer>view(String token);
	public int getSize(String token);
}

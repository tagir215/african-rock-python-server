package com.tiger.designPatterns200.model.shoppingCart;

import com.tiger.designPatterns200.service.shoppingCart.CartEvent;

public interface Subscriber {
	public void update(CartEvent event);
}

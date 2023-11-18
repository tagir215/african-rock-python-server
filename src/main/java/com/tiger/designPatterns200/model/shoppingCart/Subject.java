package com.tiger.designPatterns200.model.shoppingCart;

import com.tiger.designPatterns200.service.shoppingCart.CartEvent;

public interface Subject {
	public void subscribe(Subscriber s);
	public void unsubscribe(Subscriber s);
	public void notifySubscribers(CartEvent event); 
}

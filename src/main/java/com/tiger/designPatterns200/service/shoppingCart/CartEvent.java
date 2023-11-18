package com.tiger.designPatterns200.service.shoppingCart;

import org.springframework.context.ApplicationEvent;

import com.tiger.designPatterns200.model.shoppingCart.CartItemDTO;

public class CartEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CartItemDTO cart;
	
	public CartEvent(Object source,CartItemDTO cart) {
		super(source);
		this.cart = cart;
	}

	public CartItemDTO getContent() {
		return cart;
	}
	
	

}

package com.tiger.designPatterns200.service.shoppingCart;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.shoppingCart.CartItemDTO;
import com.tiger.designPatterns200.model.shoppingCart.ShoppingCart;

@Component
public class CartLoggedInService implements ShoppingCart{

	@Override
	public void addItem(CartItemDTO cartItem, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(CartItemDTO cartItem, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear(String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Computer> view(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	


}

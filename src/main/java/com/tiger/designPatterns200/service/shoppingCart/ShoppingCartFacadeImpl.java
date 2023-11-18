package com.tiger.designPatterns200.service.shoppingCart;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.shoppingCart.CartItemDTO;
import com.tiger.designPatterns200.model.shoppingCart.ShoppingCart;
import com.tiger.designPatterns200.model.shoppingCart.ShoppingCartFacade;
import com.tiger.designPatterns200.model.shoppingCart.Subject;
import com.tiger.designPatterns200.model.shoppingCart.Subscriber;

@Component
public class ShoppingCartFacadeImpl implements ShoppingCartFacade {
	private final CartLoggedOffService cartLoggedOffState;
	private final CartLoggedInService cartLoggedInState;
	private ShoppingCart currentCartState;
	private final Subject subject;
	

	/**
	 * @param cartLoggedOffState
	 * @param cartLoggedInState
	 * @param subject
	 * State different if logged in or anonymous, and also notifies subscribers. 
	 * Basically I just wanted to use the Facade Design pattern somehow
	 */
	public ShoppingCartFacadeImpl(CartLoggedOffService cartLoggedOffState, CartLoggedInService cartLoggedInState,
			Subject subject) {
		this.cartLoggedOffState = cartLoggedOffState;
		this.cartLoggedInState = cartLoggedInState;
		this.subject = subject;
		currentCartState = cartLoggedOffState;
	}

	
	public void subscribe(Subscriber s) {
		subject.subscribe(s);
	}
	public void unsubscribe(Subscriber s) {
		subject.unsubscribe(s);
	}

	@Override
	public void notifySubscribers(CartEvent event) {
		subject.notifySubscribers(event);
	}


	@Override
	public void addItem(CartItemDTO cartItem, String cookie) {
		currentCartState.addItem(cartItem, cookie);
		notifySubscribers(new CartEvent(this,cartItem));
	}


	@Override
	public void removeItem(CartItemDTO cartItem, String cookie) {
		currentCartState.removeItem(cartItem, cookie);
		notifySubscribers(new CartEvent(this,cartItem));
	}


	@Override
	public void clear(String token) {
		currentCartState.clear(token);
		notifySubscribers(new CartEvent(this,null));
	}


	@Override
	public List<Computer> view(String token) {
		return currentCartState.view(token);
	}


	@Override
	public int getSize(String token) {
		return currentCartState.getSize(token);
	}
		
}

	

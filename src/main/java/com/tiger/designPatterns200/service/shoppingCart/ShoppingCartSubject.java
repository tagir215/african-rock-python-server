package com.tiger.designPatterns200.service.shoppingCart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiger.designPatterns200.model.shoppingCart.Subject;
import com.tiger.designPatterns200.model.shoppingCart.Subscriber;

/**
 * @author OMISTAJA
 *
 */
@Component
public class ShoppingCartSubject  implements Subject{
	private final List<Subscriber>subscribers = new ArrayList<>();
	
	
	public void subscribe(Subscriber s) {
		subscribers.add(s);
	}
	public void unsubscribe(Subscriber s) {
		subscribers.remove(s);
	}
	@Override
	public void notifySubscribers(CartEvent event) {
		
		for(Subscriber s : subscribers) {
			s.update(event);
		}
	}
	

	
	
	
	
}

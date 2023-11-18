package com.tiger.designPatterns200.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.shoppingCart.CartItemDTO;
import com.tiger.designPatterns200.model.shoppingCart.ShoppingCartFacade;
import com.tiger.designPatterns200.service.factory.cookieFactory.SimpleCookieFactory;
import com.tiger.designPatterns200.util.ComponentMapper;

/**
 * 
 * @author OMISTAJA
 * Using requestparams to get cookies because some problems in heroku...
 */
@RestController
@RequestMapping(path="api/v1/cart")
public class CartController {
	private final ShoppingCartFacade shoppingCart;
	private final SimpleCookieFactory cookieFactory;
	private final String COOKIE_NAME = "sessionId";

	public CartController(ShoppingCartFacade shoppingCart, SimpleCookieFactory cookieFactory) {
		this.shoppingCart = shoppingCart;
		this.cookieFactory = cookieFactory;
	}

	/**
	 * @param cartItem
	 */
	@PostMapping("/add/")
	public void addProduct(@RequestBody CartItemDTO cartItem) {
		shoppingCart.addItem(cartItem, cartItem.getSessionId());
	}

	/**
	 * @param cartItem
	 */
	@PostMapping("/remove/")
	public void removeProduct(@RequestBody CartItemDTO cartItem) {
		shoppingCart.removeItem(cartItem, cartItem.getSessionId());
	}

	/**
	 * @param cookie
	 * @return
	 */
	@GetMapping("/view")
	@Transactional
	public ResponseEntity<Object> viewCart(@RequestParam("cookie") String cookie) {
		List<Computer> computers = shoppingCart.view(cookie);
		return ResponseEntity.ok(ComponentMapper.computersToDtos(computers));
	}

	/**
	 * @param cookie
	 * @return
	 */
	@GetMapping("/get-size")
	public int getSize(@RequestParam("cookie") String cookie) {
		return shoppingCart.getSize(cookie);
	}

	/**
	 * @param cookie
	 */
	@PostMapping("/clear")
	public void removeAll(@RequestParam("cookie") String cookie) {
		shoppingCart.clear(cookie);
	}

	
}
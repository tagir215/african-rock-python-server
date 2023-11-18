package com.tiger.designPatterns200.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiger.designPatterns200.model.shoppingCart.CartItemDTO;

/**
 * @author OMISTAJA
 *
 */
public class JsonMapper200 {

/**
 * @param cookie
 * @return
 */
public static List<CartItemDTO>stringToCartItemDTOs(String cookie){
		
		if(cookie==null) {
			return new ArrayList<>();
		}
		ObjectMapper mapper = new ObjectMapper();
		List<CartItemDTO>items = null;
		try {
			items = mapper.readValue(cookie, new TypeReference<List<CartItemDTO>>() {});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
	/**
	 * @param object
	 * @return
	 */
	public static String objectToJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}

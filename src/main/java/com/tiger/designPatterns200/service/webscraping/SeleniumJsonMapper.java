package com.tiger.designPatterns200.service.webscraping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author OMISTAJA
 *
 */
public class SeleniumJsonMapper {
	
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param url
	 * @param variantMap
	 * @return
	 */
	public static HashMap<String,Object> generatePart(Long id,String name,double price,String url, HashMap<String,List<String>>variantMap) {
		HashMap<String,Object>map = new LinkedHashMap<>();
		map.put("id",id);
		map.put("name", name);
		map.put("price", price);
		map.put("url", url);
		for(String key : variantMap.keySet()) {
			map.put(key, variantMap.get(key));
		}
		
		return map;
	}
	
	/**
	 * @param json
	 * @return
	 */
	public static HashMap<String,HashMap<String,Object>>jsonToMap(String json){
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, HashMap<String, Object>> map = null;
		try {
			map = mapper.readValue(json, HashMap.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * @param map
	 * @return
	 */
	public static String mapToJson(HashMap<String,HashMap<String,Object>>map) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

}

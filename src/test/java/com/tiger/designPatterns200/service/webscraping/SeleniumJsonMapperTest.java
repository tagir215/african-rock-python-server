package com.tiger.designPatterns200.service.webscraping;

import java.io.InputStream;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.tiger.designPatterns200.repository.FileManager;

class SeleniumJsonMapperTest {

	@Test
	void testJsonToMap() {
		FileManager fileManager = new FileManager();
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("realData/motherboards.json");
		String json = fileManager.streamToString(stream);
		HashMap<String,HashMap<String,Object>>map = SeleniumJsonMapper.jsonToMap(json);
		for(String key : map.keySet()) {
			System.out.println(key);
			for(Object o : map.get(key).values()) {
				System.out.println(o);
			}
		}
	}

}

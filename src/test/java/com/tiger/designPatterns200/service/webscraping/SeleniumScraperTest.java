package com.tiger.designPatterns200.service.webscraping;

import java.io.InputStream;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiger.designPatterns200.repository.FileManager;

class SeleniumScraperTest {

	@Test
	void testCreateProduct() {
		SeleniumScraper scraper = new SeleniumScraper();
		String url = "https://pc-builder.io/motherboard";
		HashMap<String,HashMap<String,Object>>productMap = scraper.createProductMap(url,1000000);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String json = objectMapper.writeValueAsString(productMap);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	void testCreateCompatibleProducts() {
		SeleniumScraper scraper = new SeleniumScraper();
		FileManager fileManager = new FileManager();
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("realData/gpus.json");
		String json = fileManager.streamToString(stream);
		HashMap<String,HashMap<String,Object>>productMap = SeleniumJsonMapper.jsonToMap(json);
		HashMap<String,HashMap<String,Object>>resultMap = new HashMap<>();
		scraper.compatibleProductsSuperviser(resultMap,productMap, "Compatible Power Supplies",20);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String json2 = objectMapper.writeValueAsString(resultMap);
			String json3 = objectMapper.writeValueAsString(productMap);
			System.out.println(json2);
			System.out.println(json3);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	

}

package com.tiger.designPatterns200.service.webscraping;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tiger.designPatterns200.repository.FileManager;

/**
 * @author OMISTAJA
 * 
 */
public class ManualDataManipulator {
	/**
	 * @param i1
	 * @param i2
	 * @return
	 * combines two separately scraped files into one
	 */
	public static String combine(InputStream i1, InputStream i2) {
		FileManager fileManager = new FileManager();
		String json1 = fileManager.streamToString(i1);
		String json2 = fileManager.streamToString(i2);
		HashMap<String,HashMap<String,Object>>map1 = SeleniumJsonMapper.jsonToMap(json1);
		HashMap<String,HashMap<String,Object>>map2 = SeleniumJsonMapper.jsonToMap(json2);
		
		List<long[]>ids = new ArrayList<>();
		long startingId = map1.size()+1;
		
		for(String key : map2.keySet()) {
			if(map1.get(key)==null) {
				map1.put(key, map2.get(key));
				long id =Long.valueOf((int)map2.get(key).get("id") );
				map2.get(key).put("id", startingId);
				ids.add(new long[]{id,startingId});
				startingId++;
			}
		}
		
		for(long[] ida : ids) {
			System.out.println(ida[0]+" -> "+ida[1]);
		}
		
		String json = SeleniumJsonMapper.mapToJson(map1);
		return json;
	}
}

package com.tiger.designPatterns200.service.component;

import java.math.BigDecimal;
import java.util.List;

import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.model.component.CompatibilityComponent;

/**
 * @author OMISTAJA
 *
 */
public class ComponentFilterer {
	
	 /**
	 * @param <T>
	 * @param maxPrice
	 * @param entities
	 * @param compatibilityChecks
	 * @return
	 * finds the best match by selecting highest priced component from the collection that is still under the 
	 * max budget. But if none are found the budgets max price is elevated and the method is called recursively.
	 * Also if CompatibilityComponents are passed in, it will filter incompatible parts out.
	 */
	public static <T extends ComponentEntity> T findBestMatch(float maxPrice, List<T> entities, CompatibilityComponent... compatibilityChecks) {
	        T bestMatch = null;
	        BigDecimal price = BigDecimal.valueOf(maxPrice);
	        BigDecimal bestDifference = BigDecimal.valueOf(Double.MAX_VALUE);
	        
	        for (T entity : entities) {
	        	for(CompatibilityComponent cc : compatibilityChecks) {
	        		if(!cc.checkCompatibility(entity.getClass(), entity.getId())) {
	        			continue;
	        		}
	        	}
	            if (entity.getPrice().compareTo(price) <= 0) {
	                BigDecimal difference = price.subtract(entity.getPrice());
	                if (difference.compareTo(bestDifference) < 0) {
	                    bestDifference = difference;
	                    bestMatch = entity;
	                }
	            }
	        }
	        if(bestMatch==null) {
	        	return findBestMatch(maxPrice+20f,entities,compatibilityChecks);
	        }else {	        	
	        	return bestMatch;
	        }
	    }
}

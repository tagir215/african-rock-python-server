package com.tiger.designPatterns200.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tiger.designPatterns200.entity.component.ComponentEntity;

/**
 * @author OMISTAJA
 * 
 */
public class CollectionUtils {
	/**
	 * @param <T>
	 * @param list
	 * @param clazz
	 * @return
	 */
	public static<T extends ComponentEntity> List<T> castList(List<ComponentEntity> list, Class<T> clazz) {
	    List<T> result = new ArrayList<>();
	    for (ComponentEntity entity : list) {
			result.add(clazz.cast(entity));
	     
	    }
	    return result;
	}
	
	/**
	 * @param <T>
	 * @param list
	 * @param id
	 * @return
	 */
	public static<T extends ComponentEntity> boolean listContainsId(List<T>list, Long id) {
		for(ComponentEntity item : list) {
			if(item.getId()==id) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @param <T>
	 * @param list
	 * @param id
	 * @return
	 */
	public static<T extends ComponentEntity> T getFromListById(List<T>list, Long id) {
		for(ComponentEntity item : list) {
			if(item.getId()==id) {
				return (T) item;
			}
		}
		return null;
	}

	/**
	 * @param <T>
	 * @param list
	 * @param filterIds
	 * @return
	 */
	public static<T extends ComponentEntity> List<ComponentEntity> filterByListIds(List<T>list, List<Long>filterIds) {
		List<ComponentEntity>result = new ArrayList<>();
		HashMap<Long,Boolean>filterMap = new HashMap<>();
		for(Long l: filterIds) {
			filterMap.put(l,true);
		}
		for(T t : list) {
			if(filterMap.get(t.getId())!=null) {
				result.add(t);
			}
		}
		return result;
	}
}

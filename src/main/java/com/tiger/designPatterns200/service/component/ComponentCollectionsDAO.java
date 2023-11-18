package com.tiger.designPatterns200.service.component;

import com.tiger.designPatterns200.model.component.ComponentCollections;

/**
 * @author OMISTAJA
 * implementing with jackson for now from json files, but might switch to mysql
 */
public interface ComponentCollectionsDAO {
	 ComponentCollections getComponentCollections();
}

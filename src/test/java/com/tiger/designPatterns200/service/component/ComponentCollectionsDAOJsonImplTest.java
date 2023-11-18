package com.tiger.designPatterns200.service.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tiger.designPatterns200.model.component.ComponentCollections;

class ComponentCollectionsDAOJsonImplTest {

	@Test
	void test() {
		ComponentCollectionsDAOJsonImpl dao = new ComponentCollectionsDAOJsonImpl();
		ComponentCollections collections = dao.getComponentCollections();
		Assertions.assertEquals(23, collections.cases().size());
		Assertions.assertEquals(33, collections.coolers().size());
		Assertions.assertEquals(77, collections.cpus().size());
		Assertions.assertEquals(20, collections.gpus().size());
		Assertions.assertEquals(100, collections.motherboards().size());
		Assertions.assertEquals(20, collections.powerUnits().size());
		Assertions.assertEquals(82, collections.rams().size());
		Assertions.assertEquals(20, collections.storages().size());
	}

	@Test
	void testSaveGpus() {
		
	}
}

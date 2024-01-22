package com.tiger.designPatterns200.service.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.entity.component.CpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;
import com.tiger.designPatterns200.model.component.ComponentCollections;

@SpringBootTest
class ComponentCollectionsDAOJsonImplTest {

	@Test
	void testGetCorrectSizedCollectionsFromDAO() {
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
		
		for(ComponentEntity e : collections.motherboards()) {
			MotherboardEntity m = (MotherboardEntity) e;
			if(m.getId()==48) {
				for(CpuEntity cpu : m.getCompatibleCPUs()) {
					Assertions.assertTrue(cpu.getId()>20 && cpu.getId()<40);
				}
			}
		}
	}

	@Test
	void testSaveGpus() {
		
	}
}

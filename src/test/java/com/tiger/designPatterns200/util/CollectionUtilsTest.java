package com.tiger.designPatterns200.util;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.entity.component.CpuEntity;

class CollectionUtilsTest {
	
	List<ComponentEntity> componentEntities = new ArrayList<>();

	@BeforeEach
	void setup() {
        CpuEntity entity1 = new CpuEntity();
        CpuEntity entity2 = new CpuEntity();
        CpuEntity entity3 = new CpuEntity();
        entity1.setId(0L);
        entity2.setId(1L);
        entity3.setId(3L);
        componentEntities.add(entity1); 
        componentEntities.add(entity2); 
        componentEntities.add(entity3); 
	}

    @Test
    void testCastList() {
        List<CpuEntity> castedEntities = CollectionUtils.castList(componentEntities, CpuEntity.class);
        assertEquals(3, castedEntities.size());
        assertTrue(castedEntities.get(0) instanceof CpuEntity);
    }

    @Test
    void testListContainsId() {
        assertTrue(CollectionUtils.listContainsId(componentEntities, 1L), "List should contain ID 1");
        assertTrue(CollectionUtils.listContainsId(componentEntities, 3L), "List should not contain ID 3");
        assertFalse(CollectionUtils.listContainsId(componentEntities, 4L), "List should not contain ID 3");
    }

    @Test
    void testGetFromListById() {
        assertEquals(1L, CollectionUtils.getFromListById(componentEntities, 1L).getId(), "Should get entity with ID 1");
        assertNull(CollectionUtils.getFromListById(componentEntities, 4L), "Should get null for ID 3");
    }

    @Test
    void testFilterByListIds() {
        List<Long> filterIds = Arrays.asList(1L, 3L);
        List<ComponentEntity> filteredEntities = CollectionUtils.filterByListIds(componentEntities, filterIds);
        for(ComponentEntity e : filteredEntities) {
        	assertTrue(e.getId()==1L || e.getId()==3L);
        }
        assertEquals(2, filteredEntities.size(), "Filtered list size should be 2");
        assertTrue(filteredEntities.get(0) instanceof CpuEntity, "First element should be an instance of CpuEntity");
    }
}


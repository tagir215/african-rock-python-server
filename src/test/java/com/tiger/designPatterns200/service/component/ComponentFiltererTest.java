package com.tiger.designPatterns200.service.component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.entity.component.CaseEntity;
import com.tiger.designPatterns200.entity.component.GpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;

class ComponentFiltererTest {
	MotherboardEntity motherboard;
	GpuEntity gpu;
	List<CaseEntity>caseEntitys;
	
	@BeforeEach
	void setup() {
		motherboard = new MotherboardEntity();
		gpu = new GpuEntity();
		caseEntitys = new ArrayList<>();
		var caseEntity1 = new CaseEntity();
		var caseEntity2 = new CaseEntity();
		var caseEntity3 = new CaseEntity();
		var caseEntity4 = new CaseEntity();
		var caseEntity5 = new CaseEntity();
		var caseEntity6 = new CaseEntity();

		caseEntity1.setId(0L);
		caseEntity2.setId(1L);
		caseEntity3.setId(2L);
		caseEntity4.setId(3L);
		caseEntity5.setId(4L);
		caseEntity6.setId(5L);

		caseEntity1.setPrice(BigDecimal.valueOf(0));
		caseEntity2.setPrice(BigDecimal.valueOf(40f));
		caseEntity3.setPrice(BigDecimal.valueOf(80f));
		caseEntity4.setPrice(BigDecimal.valueOf(99f));
		caseEntity5.setPrice(BigDecimal.valueOf(500f));
		caseEntity6.setPrice(BigDecimal.valueOf(999f));

		caseEntitys.add(caseEntity1);
		caseEntitys.add(caseEntity2);
		caseEntitys.add(caseEntity3);
		caseEntitys.add(caseEntity4);
		caseEntitys.add(caseEntity5);
		caseEntitys.add(caseEntity6);

		List<CaseEntity>compatibleCases = new ArrayList<>();
		compatibleCases.add(caseEntity1);
		compatibleCases.add(caseEntity3);
		compatibleCases.add(caseEntity5);
		motherboard.setCompatibleCases(compatibleCases);

		
		List<CaseEntity>compatibleCases2 = new ArrayList<>();
		compatibleCases2.add(caseEntity1);
		compatibleCases2.add(caseEntity4);
		compatibleCases2.add(caseEntity5);
		compatibleCases2.add(caseEntity6);
		gpu.setCompatibleCases(compatibleCases2);
	}

	@Test
	void testFilteringComponentsPriceAlone() {
		ComponentEntity e = ComponentFilterer.findBestMatch(100.0f, caseEntitys);
		Assertions.assertEquals(3L, e.getId());
	}

	@Test
	void testFilteringComponentsPriceAndMotherboard() {
		ComponentEntity e = ComponentFilterer.findBestMatch(100.0f, caseEntitys, motherboard);
		Assertions.assertEquals(2L, e.getId());
	}

	@Test
	void testFilteringComponentsPriceAndMotherboardAndGpu() {
		ComponentEntity e = ComponentFilterer.findBestMatch(100.0f, caseEntitys, motherboard, gpu);
		Assertions.assertEquals(0L, e.getId());
	}
}

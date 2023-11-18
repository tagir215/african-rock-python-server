package com.tiger.designPatterns200.service.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.designPatterns200.repository.component.ComponentRepository;

@SpringBootTest
@Transactional
class ComponentServiceTest {
	
	@Autowired
	ComponentRepository repository;

	@Test
	void testComponentCollectionsToMysql() {
		
	}

}

package com.tiger.designPatterns200.service.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tiger.designPatterns200.model.component.ComponentCollections;
import com.tiger.designPatterns200.repository.component.ComponentRepository;

@SpringBootTest
class ComponentUploadServiceTest {

	
	@Autowired
	ComponentCollectionsDAO dao;
	@Autowired
	ComponentRepository repository;
	ComponentCollections collections;
	ComponentUploadService service;

	@BeforeEach
	void setup() {
		service = new ComponentUploadService(repository);
		collections = dao.getComponentCollections();
	}
	
	@Test
	void testSaveGenerics() {
		service.saveGenericComponents(collections);
		
	}
	
	@Test
	void testSaveGpu() {
		service.saveCollectionInParts(collections.gpus(),0,collections.gpus().size());
	}
	
	@Test
	void testSaveMotherboards() {
		service.saveCollectionInParts(collections.motherboards(),80,99);
	}

}

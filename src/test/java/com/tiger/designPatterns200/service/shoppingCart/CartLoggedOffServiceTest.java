package com.tiger.designPatterns200.service.shoppingCart;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.shoppingCart.CartItemDTO;
import com.tiger.designPatterns200.repository.shoppingCart.CartItemRepository;
import com.tiger.designPatterns200.service.component.ComponentService;

@SpringBootTest
class CartLoggedOffServiceTest {
	
	
	@Autowired
	CartItemRepository repository2;
	
	@Autowired
	ComponentService service;
	
	
	
	CartItemDTO dto;
	
	String token = "809frsfrf4850398rrwf5039845034845";
	
	CartLoggedOffService shoppingCart;
	
	@BeforeEach
	void setup() {
		dto = new CartItemDTO();
		dto.setCaseId(2);
		dto.setCpuCoolerId(1);
		dto.setCpuId(1);
		dto.setGpuId(1);
		dto.setMotherboardId(1);
		dto.setOs("add later lol");
		dto.setOsVersion("later lol");
		dto.setPowerUnitId(1);
		dto.setRamId(1);
		dto.setStorageId(1);
		shoppingCart = new CartLoggedOffService(service,repository2);
	}
	
	@Test
	void testAddItem() {
		shoppingCart.addItem(dto, token);
	}
	
	//@Test
	void testRemoveItem() {
		shoppingCart.removeItem(dto, token);
	}
	
	@Test
	@Transactional
	void testView() {
		List<Computer>computers = shoppingCart.view(token);
		Computer computer = computers.get(0);

		Assertions.assertNotNull(computer.getMotherboard());
		Assertions.assertNotNull(computer.getPcCase());
		Assertions.assertNotNull(computer.getCpuCooler());
		Assertions.assertNotNull(computer.getCpu());
		Assertions.assertNotNull(computer.getGpu());
		Assertions.assertNotNull(computer.getPowerUnit());
		Assertions.assertNotNull(computer.getRam());
		Assertions.assertNotNull(computer.getStorage());
		
	}
	

}

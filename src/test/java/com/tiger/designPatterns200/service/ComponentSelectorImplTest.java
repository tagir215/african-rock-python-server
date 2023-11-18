package com.tiger.designPatterns200.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiger.designPatterns200.entity.component.CpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;
import com.tiger.designPatterns200.model.component.SelectedComponents;
import com.tiger.designPatterns200.service.component.ComponentCollectionsDAO;
import com.tiger.designPatterns200.service.component.ComponentSelector;
import com.tiger.designPatterns200.service.component.ComponentSelectorImpl;
import com.tiger.designPatterns200.service.factory.computerFactory.ComputerInfo;

@ExtendWith(MockitoExtension.class)
class ComponentSelectorImplTest {
	
	@Autowired
	ComponentCollectionsDAO dao;
	
	@Mock 
	ComputerInfo computerInfo;
	List<MotherboardEntity>motherboards = new ArrayList<>();
	List<CpuEntity>cpus = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		Mockito.when(computerInfo.getX_motherboard()).thenReturn(1f);
		Mockito.when(computerInfo.getX_case()).thenReturn(1f);
		Mockito.when(computerInfo.getX_cooler()).thenReturn(1f);
		Mockito.when(computerInfo.getX_cpu()).thenReturn(1f);
		Mockito.when(computerInfo.getX_gpu()).thenReturn(1f);
		Mockito.when(computerInfo.getX_powerUnit()).thenReturn(1f);
		Mockito.when(computerInfo.getX_ram()).thenReturn(1f);
		Mockito.when(computerInfo.getX_storage()).thenReturn(1f);
	}
	
	
	@Test
	void testGetSuperComponentsFromData() {
		ComponentSelector selector = new ComponentSelectorImpl(dao);
		
		Mockito.when(computerInfo.getBudget()).thenReturn(500f);
		SelectedComponents components = selector.selectComponents(computerInfo);
		System.out.println(components.motherboard().getName());
		System.out.println(components.gpu().getName());
		System.out.println(components.cooler().getName());
		System.out.println(components.cpu().getName());
		System.out.println(components.powerUnit().getName());
		System.out.println(components.ram().getName());
		System.out.println(components.storage().getName());
		;
		
	}

}

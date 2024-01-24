package com.tiger.designPatterns200.service.component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.entity.component.CpuEntity;
import com.tiger.designPatterns200.entity.component.GpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;
import com.tiger.designPatterns200.model.component.ComponentCollections;
import com.tiger.designPatterns200.service.factory.computerFactory.ComputerInfo;

@ExtendWith(MockitoExtension.class)
class ComponentSelectorImplTest {
	
	@Mock
	ComponentCollectionsDAO dao;
	
	ComponentCollections collections;
	
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
		
		
		var m0 = new MotherboardEntity();
		var m1 = new MotherboardEntity();
		m0.setId(0L);
		m1.setId(1L);
		m0.setPrice(BigDecimal.valueOf(100));
		m1.setPrice(BigDecimal.valueOf(400));
		
		var gpu0 = new GpuEntity();
		var gpu1 = new GpuEntity();
		gpu0.setId(0L);
		gpu1.setId(1L);
		gpu0.setPrice(BigDecimal.valueOf(100));
		gpu1.setPrice(BigDecimal.valueOf(400));

		var cpu0 = new CpuEntity();
		var cpu1 = new CpuEntity();
		cpu0.setId(0L);
		cpu1.setId(1L);
		cpu0.setPrice(BigDecimal.valueOf(100));
		cpu1.setPrice(BigDecimal.valueOf(400));

		List<GpuEntity>compatibleGpus = new ArrayList<>();
		List<CpuEntity>compatibleCpus = new ArrayList<>();
		compatibleGpus.add(gpu0);
		compatibleGpus.add(gpu1);
		//compatibleCpus.add(cpu0);
		compatibleCpus.add(cpu1);
		
		m0.setCompatibleGPUs(compatibleGpus);
		m0.setCompatibleCPUs(compatibleCpus);

		List<GpuEntity>compatibleGpus2 = new ArrayList<>();
		List<CpuEntity>compatibleCpus2 = new ArrayList<>();
		compatibleGpus2.add(gpu0);
		//compatibleGpus2.add(gpu1);
		compatibleCpus2.add(cpu0);
		compatibleCpus2.add(cpu1);
		m1.setCompatibleGPUs(compatibleGpus2);
		m1.setCompatibleCPUs(compatibleCpus2);
		
		
		List<ComponentEntity>motherboards = new ArrayList<>();
		List<ComponentEntity>gpus = new ArrayList<>();
		List<ComponentEntity>cpus = new ArrayList<>();
		motherboards.add(m0);
		motherboards.add(m1);
		gpus.add(gpu0);
		gpus.add(gpu1);
		cpus.add(cpu0);
		cpus.add(cpu1);
		
		collections = new ComponentCollections(motherboards,null,null,cpus,gpus,null,null,null);
		Mockito.when(dao.getComponentCollections()).thenReturn(collections);
	}
	
	
	@Test
	void testBudget120(){
		Mockito.when(computerInfo.getBudget()).thenReturn(120f);
		ComponentSelector selector = new ComponentSelectorImpl(dao);
		var selectedComponents = selector.selectComponents(computerInfo);
		Assertions.assertEquals(selectedComponents.motherboard().getId(), 0);
		Assertions.assertEquals(selectedComponents.cpu().getId(), 1);
		Assertions.assertEquals(selectedComponents.gpu().getId(), 0);
	}


	@Test
	void testBudget420(){
		Mockito.when(computerInfo.getBudget()).thenReturn(420f);
		ComponentSelector selector = new ComponentSelectorImpl(dao);
		var selectedComponents = selector.selectComponents(computerInfo);
		Assertions.assertEquals(selectedComponents.motherboard().getId(), 1);
		Assertions.assertEquals(selectedComponents.cpu().getId(), 1);
		Assertions.assertEquals(selectedComponents.gpu().getId(), 0);
	}
}

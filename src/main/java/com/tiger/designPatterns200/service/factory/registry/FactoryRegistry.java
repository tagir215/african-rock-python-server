package com.tiger.designPatterns200.service.factory.registry;

import java.util.HashMap;


import org.springframework.stereotype.Component;

import com.tiger.designPatterns200.service.component.ComponentSelector;
import com.tiger.designPatterns200.service.factory.computerFactory.AbstractComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.ComputerStrings;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.AudioProductionComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.BasicComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.CryptoComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.DeepLearningComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.GamingComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.HomeTheaterComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.SecurityComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.SilentComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.VirtualRealityComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.WorkStationComputerFactory;


/**
 * @author OMISTAJA
 * Registry for factories...
 */
@Component
public class FactoryRegistry {
	private HashMap<String,AbstractComputerFactory>factoryMap = new HashMap<>();

	public FactoryRegistry(ComponentSelector selector) {
		
		factoryMap.put(ComputerStrings.BASIC, new BasicComputerFactory(selector));
		factoryMap.put(ComputerStrings.GAMING,new GamingComputerFactory(selector));
		factoryMap.put(ComputerStrings.WORK, new WorkStationComputerFactory(selector));
		factoryMap.put(ComputerStrings.AUDIO, new AudioProductionComputerFactory(selector));
		factoryMap.put(ComputerStrings.HOME_THEATER, new HomeTheaterComputerFactory(selector));
		factoryMap.put(ComputerStrings.SECURITY, new SecurityComputerFactory(selector));
		factoryMap.put(ComputerStrings.SILENT, new SilentComputerFactory(selector));
		factoryMap.put(ComputerStrings.VR, new VirtualRealityComputerFactory(selector));
		factoryMap.put(ComputerStrings.AI, new DeepLearningComputerFactory(selector));
		factoryMap.put(ComputerStrings.CRYPTO, new CryptoComputerFactory(selector));
	}
	
	/**
	 * @return
	 */
	public HashMap<String, AbstractComputerFactory> getFactoryMap() {
		return factoryMap;
	}

	
	
}

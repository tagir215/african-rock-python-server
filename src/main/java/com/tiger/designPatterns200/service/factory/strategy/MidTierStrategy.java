package com.tiger.designPatterns200.service.factory.strategy;

import com.tiger.designPatterns200.exception.factory.ComponentSelectorException;
import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.service.factory.computerFactory.AbstractComputerFactory;

public class MidTierStrategy implements BuildingStrategy{

	@Override
	public Computer buildComputer(AbstractComputerFactory factory){
		return factory.buildMidTierComputer();
	}
	
}

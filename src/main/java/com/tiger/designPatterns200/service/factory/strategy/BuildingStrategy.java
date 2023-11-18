package com.tiger.designPatterns200.service.factory.strategy;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.service.factory.computerFactory.AbstractComputerFactory;
public interface BuildingStrategy {
	Computer buildComputer(AbstractComputerFactory factory);
}

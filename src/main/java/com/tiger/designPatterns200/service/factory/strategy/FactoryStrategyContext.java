package com.tiger.designPatterns200.service.factory.strategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.service.factory.computerFactory.AbstractComputerFactory;

@Component
public class FactoryStrategyContext {
	public List<Computer> executeFactoryStrategy(AbstractComputerFactory factory,BuildingStrategy strategy){
		List<Computer>computers = new ArrayList<>();
		for(int i=0; i<20; i++) {
			Computer computer = strategy.buildComputer(factory);
			computer.setId(i);
			computers.add(computer);
		}
		return computers;
	}


}

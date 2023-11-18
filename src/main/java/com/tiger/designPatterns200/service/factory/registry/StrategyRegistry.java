package com.tiger.designPatterns200.service.factory.registry;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.tiger.designPatterns200.service.factory.computerFactory.ComputerStrings;
import com.tiger.designPatterns200.service.factory.strategy.BudgetTierStrategy;
import com.tiger.designPatterns200.service.factory.strategy.BuildingStrategy;
import com.tiger.designPatterns200.service.factory.strategy.EnthusiastStrategy;
import com.tiger.designPatterns200.service.factory.strategy.HighEndStrategy;
import com.tiger.designPatterns200.service.factory.strategy.MidTierStrategy;

@Component
public class StrategyRegistry {
	private HashMap<String,BuildingStrategy>strategyMap = new HashMap<>();

	public StrategyRegistry() {
		strategyMap.put(ComputerStrings.BUDGET, new BudgetTierStrategy());
		strategyMap.put(ComputerStrings.MIDTIER,new MidTierStrategy());
		strategyMap.put(ComputerStrings.HIGHEND, new HighEndStrategy());
		strategyMap.put(ComputerStrings.ENTHUSIAST, new EnthusiastStrategy());
	}
	public HashMap<String, BuildingStrategy> getStrategyMap() {
		return strategyMap;
	}


}

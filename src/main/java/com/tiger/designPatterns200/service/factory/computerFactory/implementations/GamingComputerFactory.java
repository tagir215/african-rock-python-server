package com.tiger.designPatterns200.service.factory.computerFactory.implementations;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.service.component.ComponentSelector;
import com.tiger.designPatterns200.service.factory.computerFactory.AbstractComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.ComputerInfo;

/**
 * 
 * @author OMISTAJA
 * 
 */
public class GamingComputerFactory extends AbstractComputerFactory {
	private ComputerInfo info;
	protected final int BUDGET_MAX = 700;
	protected final int MIDTIER_MAX = 1000;
	protected final int HIGHEND_MAX = 1700;
	protected final int ENTHUSIAST_MAX =50000;
	
    public GamingComputerFactory(ComponentSelector selector) {
    	super(selector);
    	info = new ComputerInfo();
		info.setX_case(0.05f);
		info.setX_cooler(0.05f);
		info.setX_cpu(0.2f);
		info.setX_gpu(0.4f);
		info.setX_motherboard(0.05f);
		info.setX_powerUnit(0.5f);
		info.setX_ram(0.1f);
		info.setX_storage(0.1f);
	}

	@Override
    public Computer buildBudgetComputer(){
    	return buildComputer(BUDGET_MAX, info);
    }

    @Override
    public Computer buildMidTierComputer(){
    	return buildComputer(MIDTIER_MAX, info);
    }

    @Override
    public Computer buildHighEndComputer(){
    	return buildComputer(HIGHEND_MAX, info);
    }

    @Override
    public Computer buildEnthusiastComputer(){
    	return buildComputer(ENTHUSIAST_MAX, info);
    }
}

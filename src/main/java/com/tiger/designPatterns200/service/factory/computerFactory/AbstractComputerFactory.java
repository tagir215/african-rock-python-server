package com.tiger.designPatterns200.service.factory.computerFactory;

import java.util.Random;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.component.SelectedComponents;
import com.tiger.designPatterns200.service.component.ComponentSelector;

/**
 * @author OMISTAJA
 *
 */
public abstract class AbstractComputerFactory {
	
	protected ComponentSelector componentSelector;
	
	/**
	 * @param componentSelector
	 */
	public AbstractComputerFactory(ComponentSelector componentSelector) {
		this.componentSelector = componentSelector;
	}
	public abstract Computer buildBudgetComputer();
	public abstract Computer buildMidTierComputer();
	public abstract Computer buildHighEndComputer();
	public abstract Computer buildEnthusiastComputer();
	
	
	
	/**
	 * @author OMISTAJA
	 * shuffles values so we get variety of builds
	 */
	private interface Shuffler{
		public void shuffle();
	}
	
	/**
	 * @return
	 */
	public float random() {
		Random random = new Random();
		float minValue = -0.2f;
		float maxValue = 0.2f;
		float value = minValue + (maxValue-minValue) * random.nextFloat();
		return value;
	}
		
	/**
	 * @param info
	 */
	private void shuffleValues(ComputerInfo info) {
		Shuffler[] shufflers = new Shuffler[] {
				()->{info.setX_case(info.getX_case()+random());},
				()->{info.setX_cooler(info.getX_cooler()+random());},
				()->{info.setX_cpu(info.getX_cpu()+random());;},
				()->{info.setX_gpu(info.getX_gpu()+random());},
				()->{info.setX_motherboard(info.getX_motherboard()+random());},
				()->{info.setX_powerUnit(info.getX_powerUnit()+random());},
				()->{info.setX_ram(info.getX_ram()+random());},
				()->{info.setX_storage(info.getX_storage()+random());},
		};
		for(Shuffler shuffler : shufflers) {
			shuffler.shuffle();
		}
	}
	

	/**
	 * @param budget
	 * @param info
	 * @return
	 */
	protected Computer buildComputer(float budget,ComputerInfo info) {
	    	info.setBudget(budget);
	    	
	    	ComputerInfo infoClone = (ComputerInfo) info.clonePrototype();
	    	shuffleValues(infoClone);
	    	SelectedComponents components = componentSelector.selectComponents(infoClone);
			Computer computer = new Computer.Builder()
	         		.withCpu(components.cpu())
	         		.withGpu(components.gpu())
	         		.withMotherboard(components.motherboard())
	         		.withPcCase(components.caseEntity())
	         		.withPowerUnit(components.powerUnit())
	         		.withRam(components.ram())
	         		.withStorage(components.storage())
	         		.withCpuCooler(components.cooler())
	         		.build();
	         return computer;
			
	    	 
	   }
	
	
	
}

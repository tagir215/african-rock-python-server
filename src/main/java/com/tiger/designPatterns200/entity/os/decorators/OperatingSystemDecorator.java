package com.tiger.designPatterns200.entity.os.decorators;

import java.math.BigDecimal;

import com.tiger.designPatterns200.entity.os.OperatingSystem;

public class OperatingSystemDecorator extends OperatingSystem{
	private OperatingSystem operatingSystem;

	public OperatingSystemDecorator(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
		
	}

	@Override
	public String getModel() {
		return operatingSystem.getModel();
	}

	@Override
	public String getVersion() {
		return operatingSystem.getVersion();
	}

	@Override
	public String getFamily() {
		return operatingSystem.getFamily();
	}

	@Override
	public String getMode() {
		return operatingSystem.getMode();
	}

	@Override
	public int getMaximumSupportedMemory() {
		return operatingSystem.getMaximumSupportedMemory();
	}

	@Override
	public String getManufacturer() {
		return operatingSystem.getManufacturer();
	}

	@Override
	public BigDecimal getPrice() {
		return operatingSystem.getPrice();
	}


	
	
}

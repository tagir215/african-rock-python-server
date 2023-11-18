package com.tiger.designPatterns200.entity.os.decorators.windows;

import java.math.BigDecimal;

import com.tiger.designPatterns200.entity.os.OperatingSystem;
import com.tiger.designPatterns200.entity.os.decorators.OperatingSystemDecorator;

public class W11HomeOEM64Decorator extends OperatingSystemDecorator{

	public W11HomeOEM64Decorator(OperatingSystem operatingSystem) {
		super(operatingSystem);
	}


	@Override
	public String getModel() {
		return "Microsoft Windows 11 Home 64-bit - OEM (DVD)";
	}

	@Override
	public String getVersion() {
		return "Windows 11 Home";
	}

	@Override
	public String getMode() {
		return "64-bit";
	}

	@Override
	public int getMaximumSupportedMemory() {
		return 128;
	}


	@Override
	public BigDecimal getPrice() {
		return BigDecimal.valueOf(109.98);
	}
	
	
	


}

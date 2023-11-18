package com.tiger.designPatterns200.entity.os.decorators.windows;

import java.math.BigDecimal;

import com.tiger.designPatterns200.entity.os.OperatingSystem;
import com.tiger.designPatterns200.entity.os.decorators.OperatingSystemDecorator;

public class W81Pro64Decorator extends OperatingSystemDecorator{

	public W81Pro64Decorator(OperatingSystem operatingSystem) {
		super(operatingSystem);
	}
	

	@Override
	public String getModel() {
		return "Microsoft Windows 8 OEM 64-bit";
	}



	@Override
	public String getVersion() {
		return "Windows 8.1 Pro DE";
	}

	@Override
	public String getMode() {
		return "64-bit";
	}

	@Override
	public int getMaximumSupportedMemory() {
		return 512;
	}


	@Override
	public BigDecimal getPrice() {
		return BigDecimal.valueOf(188.07);
	}
	
	
	

	
}

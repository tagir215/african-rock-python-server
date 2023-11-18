package com.tiger.designPatterns200.service.factory.osFactory;

import java.util.HashMap;

import com.tiger.designPatterns200.entity.os.OperatingSystem;
import com.tiger.designPatterns200.entity.os.WindowsOS;

public class OSFactory {

	HashMap<String,OperatingSystem>decoratorMap = new HashMap<>();
	HashMap<String,OperatingSystem>baseOsMap = new HashMap<>();
	
	
	
	public OSFactory() {
		baseOsMap.put("windows", new WindowsOS());
	}



	public <T extends OperatingSystem>OperatingSystem createOperatingSystem(OperatingSystem os, Class<T> version) {
		try {
			T decorator = version.getDeclaredConstructor(OperatingSystem.class).newInstance(os);
			return decorator;
		} catch (Exception e) {
			throw new RuntimeException("Failed to create decorator instance.", e);
		}
	}
}

package com.tiger.designPatterns200.entity.os;

import java.math.BigDecimal;

import com.tiger.designPatterns200.entity.component.ComponentEntity;

public abstract class OperatingSystem extends ComponentEntity {
	private String model;
	private String manufacturer;
	private String family;
	private String mode;
	private String version;
	private int maximumSupportedMemory;
	
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getMaximumSupportedMemory() {
		return maximumSupportedMemory;
	}
	public void setMaximumSupportedMemory(int maximumSupportedMemory) {
		this.maximumSupportedMemory = maximumSupportedMemory;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
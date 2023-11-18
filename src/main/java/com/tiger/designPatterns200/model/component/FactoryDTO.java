package com.tiger.designPatterns200.model.component;

public class FactoryDTO {
	private String type;
	private String tier;
	private String os;
		
	public FactoryDTO() {
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
	
	
}

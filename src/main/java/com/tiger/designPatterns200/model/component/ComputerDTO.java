package com.tiger.designPatterns200.model.component;

import java.math.BigDecimal;
import java.util.List;

import com.tiger.designPatterns200.model.scraperDTOs.ComponentDTO;

public class ComputerDTO {
	private List<ComponentDTO>components;
	private BigDecimal combinedPrice; 

	public ComputerDTO(List<ComponentDTO> components) {
		this.components = components;
	}

	public List<ComponentDTO> getComponents() {
		return components;
	}

	public void setComponents(List<ComponentDTO> components) {
		this.components = components;
	}

	public BigDecimal getCombinedPrice() {
		return combinedPrice;
	}

	public void setCombinedPrice(BigDecimal combinedPrice) {
		this.combinedPrice = combinedPrice;
	}
	
	
}

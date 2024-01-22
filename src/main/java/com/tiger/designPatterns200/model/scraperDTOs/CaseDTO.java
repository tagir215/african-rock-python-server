package com.tiger.designPatterns200.model.scraperDTOs;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaseDTO extends ComponentDTO{
	
    
	@JsonProperty("Motherboard Form Factor")
    private List<String> formFactors;

    @JsonProperty("Front Panel USB")
    private List<String> frontPanelUSB;

    @JsonProperty("Part #")
    private List<String> partNumbers;
    
    @JsonProperty("Dimensions")
    private List<String>dimensions;
    
    @JsonProperty("Volume")
    private List<String>volume;

    @JsonProperty("Power Supply Shroud")
    private List<String> powerSupplyShroud;

    @JsonProperty("Color")
    private List<String> color;

    @JsonProperty("Side Panel")
    private List<String> sidePanel;

    @JsonProperty("Power Supply")
    private List<String> powerSupply;

    @JsonProperty("Type")
    private List<String> type;

    @JsonProperty("Expansion Slots")
    private List<String> expansionSlots;

    @JsonProperty("Manufacturer")
    private List<String> manufacturer;

    @JsonProperty("Model")
    private List<String> model;

    @JsonProperty("UPC Codes")
    private List<String> upcCodes;

    @JsonProperty("Drive Bays")
    private List<String> driveBays;

    @JsonProperty("Maximum Video Card Length")
    private List<String> maximumVideoCardLength;
	
    
	@Override
	public String getManufacturer() {
		return manufacturer.get(0);
	}
}


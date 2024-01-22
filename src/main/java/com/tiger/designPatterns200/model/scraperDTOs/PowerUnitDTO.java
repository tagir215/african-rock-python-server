package com.tiger.designPatterns200.model.scraperDTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PowerUnitDTO extends ComponentDTO{
	@JsonProperty("PCIe 12-Pin Connectors")
    private List<String> pcie12PinConnectors;

    @JsonProperty("Molex 4-Pin Connectors")
    private List<String> molex4PinConnectors;

    @JsonProperty("Part #")
    private List<String> partNumbers;

    @JsonProperty("ATX 4-Pin Connectors")
    private List<String> atx4PinConnectors;

    @JsonProperty("PCIe 8-Pin Connectors")
    private List<String> pcie8PinConnectors;

    @JsonProperty("Wattage")
    private List<String> wattage;

    @JsonProperty("Modular")
    private List<String> modular;

    @JsonProperty("EPS 8-Pin Connectors")
    private List<String> eps8PinConnectors;

    @JsonProperty("Type")
    private List<String>type;

    @JsonProperty("SATA Connectors")
    private List<String>sataConnectors;

    @JsonProperty("Length")
    private List<String>length;

    @JsonProperty("PCIe 6-Pin Connectors")
    private List<String>pcie6PinConnectors;

    @JsonProperty("Efficiency Rating")
    private List<String>efficiencyRating;

    @JsonProperty("Fanless")
    private List<String>fanless;

    @JsonProperty("Output")
    private List<String>output;

    @JsonProperty("Manufacturer")
    private List<String>manufacturer;

    @JsonProperty("Model")
    private List<String>model;

    @JsonProperty("UPC Codes")
    private List<String>upcCodes;

    @JsonProperty("PCIe 12+4-Pin 12VHPWR Connectors")
    private List<String>pcie12_4Pin12VHPWRConnectors;

    @JsonProperty("PCIe 6+2-Pin Connectors")
    private List<String>pcie6_2PinConnectors;
    
    @JsonProperty("Color")
    private List<String>color;
    
    @JsonProperty("Efficiency")
    private List<String>efficicency;
    
	@Override
	public String getManufacturer() {
		return manufacturer.get(0);
	}
}

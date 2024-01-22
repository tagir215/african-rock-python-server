package com.tiger.designPatterns200.model.scraperDTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RamDTO extends ComponentDTO {
	@JsonProperty("Price / GB")
    private List<String> pricePerGB;

    @JsonProperty("Speed")
    private List<String>  speed;

    @JsonProperty("Part #")
    private List<String> partNumber;

    @JsonProperty("Modules")
    private List<String> modules;

    @JsonProperty("Color")
    private List<String> color;

    @JsonProperty("Form Factor")
    private List<String> formFactor;

    @JsonProperty("CAS Latency")
    private List<String> casLatency;

    @JsonProperty("ECC / Registered")
    private List<String> eccRegistered;

    @JsonProperty("Voltage")
    private List<String> voltage;

    @JsonProperty("Manufacturer")
    private List<String> manufacturer;

    @JsonProperty("Timing")
    private List<String> timing;

    @JsonProperty("First Word Latency")
    private List<String> firstWordLatency;

    @JsonProperty("Heat Spreader")
    private List<String> heatSpreader;
    
    @JsonProperty("UPC Codes")
    private List<String> upcCodes;
    
	@Override
	public String getManufacturer() {
		return manufacturer.get(0);
	}
}


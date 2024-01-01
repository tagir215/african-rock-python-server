package com.tiger.designPatterns200.model.scraperDTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CpuDTO extends ComponentDTO {
	 	@JsonProperty("TDP")
	    private List<String> tdp;

	    @JsonProperty("L2 Cache")
	    private List<String> l2Cache;

	    @JsonProperty("Core Family")
	    private List<String> coreFamily;

	    @JsonProperty("ECC Support")
	    private List<String> eccSupport;

	    @JsonProperty("Boost Clock")
	    private List<String> boostClock;

	    @JsonProperty("L1 Cache")
	    private List<String> l1Cache;

	    @JsonProperty("Lithography")
	    private List<String> lithography;

	    @JsonProperty("Part #")
	    private List<String> partNumbers;

	    @JsonProperty("L3 Cache")
	    private List<String> l3Cache;

	    @JsonProperty("Includes CPU Cooler")
	    private List<String> includesCpuCooler;

	    @JsonProperty("Includes Cooler")
	    private List<String> includesCooler;

	    @JsonProperty("Core Count")
	    private List<String> coreCount;

	    @JsonProperty("Series")
	    private List<String> series;

	    @JsonProperty("Microarchitecture")
	    private List<String> microarchitecture;

	    @JsonProperty("Core Clock")
	    private List<String> coreClock;

	    @JsonProperty("Integrated Graphics")
	    private List<String> integratedGraphics;

	    @JsonProperty("Maximum Supported Memory")
	    private List<String> maxSupportedMemory;

	    @JsonProperty("Simultaneous Multithreading")
	    private List<String> simultaneousMultithreading;

	    @JsonProperty("Manufacturer")
	    private List<String> manufacturer;

	    @JsonProperty("Packaging")
	    private List<String> packaging;

	    @JsonProperty("UPC Codes")
	    private List<String> upcCodes;

	    @JsonProperty("Socket")
	    private List<String> socket;
	    
	    @JsonProperty("Efficiency L1 Cache")
	    private List<String>efficientlyl1cache;
	    
	    @JsonProperty("Efficiency L2 Cache")
	    private List<String>efficientlyl2cache;
    
		@Override
		public String getManufacturer() {
			return manufacturer.get(0);
		}
}

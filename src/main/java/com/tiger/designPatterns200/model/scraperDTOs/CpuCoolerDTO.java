package com.tiger.designPatterns200.model.scraperDTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CpuCoolerDTO extends ComponentDTO {
	 	@JsonProperty("Noise Level")
	    private List<String> noiseLevel;
	
	    @JsonProperty("Water Cooled")
	    private List<String> waterCooled;
	
	    @JsonProperty("Part #")
	    private List<String> partNumbers;
	
	    @JsonProperty("Color")
	    private List<String> color;
	
	    @JsonProperty("Fanless")
	    private List<String> fanless;
	
	    @JsonProperty("Manufacturer")
	    private List<String> manufacturer;
	
	    @JsonProperty("Model")
	    private List<String> model;
	
	    @JsonProperty("CPU Socket")
	    private List<String> cpuSocket;
	
	    @JsonProperty("Fan RPM")
	    private List<String> fanRPM;

	    @JsonProperty("UPC Codes")
	    private List<String>updCodes;
	
	    @JsonProperty("Height")
	    private List<String>height;
    
		@Override
		public String getManufacturer() {
			return manufacturer.get(0);
		}
}



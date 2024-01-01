package com.tiger.designPatterns200.model.scraperDTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StorageDTO extends ComponentDTO {
	@JsonProperty("Price / GB")
    private List<String>pricePerGB;

    @JsonProperty("Form Factor")
    private List<String> formFactor;

    @JsonProperty("Type")
    private List<String>type;

    @JsonProperty("NVME")
    private List<String>nvme;

    @JsonProperty("Capacity")
    private List<String>capacity;

    @JsonProperty("Part #")
    private List<String>partNumber;

    @JsonProperty("Manufacturer")
    private List<String>manufacturer;

    @JsonProperty("UPC Codes")
    private List<String>upcCodes;

    @JsonProperty("Interface")
    private List<String>interfaceType;

    @JsonProperty("Cache")
    private List<String>cache;
 
    @JsonProperty("SSD NAND Flash Type")
    private List<String>ssd_nand_flash_type;
    
	@Override
	public String getManufacturer() {
		return manufacturer.get(0);
	}
}


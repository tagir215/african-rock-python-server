package com.tiger.designPatterns200.model.scraperDTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiger.designPatterns200.model.component.CompatibilityComponent;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class GpuDTO extends ComponentDTO {
	@JsonProperty("TDP")
    private List<String>tdp;

    @JsonProperty("External Power")
    private List<String> externalPower;

    @JsonProperty("Chipset")
    private List<String> chipset;

    @JsonProperty("Boost Clock")
    private List<String> boostClock;

    @JsonProperty("Cooling")
    private List<String> cooling;

    @JsonProperty("Frame Sync")
    private List<String> frameSync;

    @JsonProperty("Part #")
    private List<String> partNumbers;

    @JsonProperty("Memory")
    private List<String> memory;

    @JsonProperty("Total Slot Width")
    private List<String> totalSlotWidth;

    @JsonProperty("DisplayPort Outputs")
    private List<String> displayPortOutputs;

    @JsonProperty("Color")
    private List<String> color;

    @JsonProperty("Case Expansion Slot Width")
    private List<String> caseExpansionSlotWidth;

    @JsonProperty("HDMI Outputs")
    private List<String> hdmiOutputs;

    @JsonProperty("Memory Type")
    private List<String> memoryType;

    @JsonProperty("Core Clock")
    private List<String> coreClock;

    @JsonProperty("Effective Memory Clock")
    private List<String> effectiveMemoryClock;

    @JsonProperty("Length")
    private List<String> length;

    @JsonProperty("Manufacturer")
    private List<String> manufacturer;

    @JsonProperty("Model")
    private List<String> model;

    @JsonProperty("Interface")
    private List<String> interfaceType;

    @JsonProperty("Compatible Cases")
    private List<Long> compatibleCases;

    @JsonProperty("Compatible Power Supplies")
    private List<Long> compatiblePowerSupplies;
    
    @JsonProperty("DisplayPort 1.4 Outputs")
    private List<String>displayPort1_4Outputs;
    
    @JsonProperty("DisplayPort 1.4a Outputs")
    private List<String>displayPort1_4aOutputs;
    
    @JsonProperty("DisplayPort 2.1 Outputs")
    private List<String>displayPort2_1Outputs;
    
    @JsonProperty("HDMI 2.1 Outputs")
    private List<String>hdmi2_1outputs;

    @JsonProperty("HDMI 2.1a Outputs")
    private List<String>hdmi2_1aoutputs;
    
    @JsonProperty("DVI-D Dual Link Outputs")
    private List<String>dvi_dDualLinkOuputs;
    
    @JsonProperty("SLI/CrossFire")
    private List<String>crossfire;
    
    @JsonProperty("UPC Codes")
    private List<String>upcCodes;

	public List<String> getTdp() {
		return tdp;
	}

	public List<String> getExternalPower() {
		return externalPower;
	}

	public List<String> getChipset() {
		return chipset;
	}

	public List<String> getBoostClock() {
		return boostClock;
	}

	public List<String> getCooling() {
		return cooling;
	}

	public List<String> getFrameSync() {
		return frameSync;
	}

	public List<String> getPartNumbers() {
		return partNumbers;
	}

	public List<String> getMemory() {
		return memory;
	}

	public List<String> getTotalSlotWidth() {
		return totalSlotWidth;
	}

	public List<String> getDisplayPortOutputs() {
		return displayPortOutputs;
	}

	public List<String> getColor() {
		return color;
	}

	public List<String> getCaseExpansionSlotWidth() {
		return caseExpansionSlotWidth;
	}

	public List<String> getHdmiOutputs() {
		return hdmiOutputs;
	}

	public List<String> getMemoryType() {
		return memoryType;
	}

	public List<String> getCoreClock() {
		return coreClock;
	}

	public List<String> getEffectiveMemoryClock() {
		return effectiveMemoryClock;
	}

	public List<String> getLength() {
		return length;
	}


	public List<String> getModel() {
		return model;
	}

	public List<String> getInterfaceType() {
		return interfaceType;
	}

	public List<Long> getCompatibleCases() {
		return compatibleCases;
	}

	public List<Long> getCompatiblePowerSupplies() {
		return compatiblePowerSupplies;
	}

	public List<String> getDisplayPort1_4Outputs() {
		return displayPort1_4Outputs;
	}

	public List<String> getDisplayPort1_4aOutputs() {
		return displayPort1_4aOutputs;
	}

	public List<String> getDisplayPort2_1Outputs() {
		return displayPort2_1Outputs;
	}

	public List<String> getHdmi2_1outputs() {
		return hdmi2_1outputs;
	}

	public List<String> getHdmi2_1aoutputs() {
		return hdmi2_1aoutputs;
	}

	public List<String> getDvi_dDualLinkOuputs() {
		return dvi_dDualLinkOuputs;
	}

	public List<String> getCrossfire() {
		return crossfire;
	}

	public List<String> getUpcCodes() {
		return upcCodes;
	}

	
	@Override
	public String getManufacturer() {
		return manufacturer.get(0);
	}
	

}
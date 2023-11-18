package com.tiger.designPatterns200.model.scraperDTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MotherboardDTO extends ComponentDTO {
	@JsonProperty("Chipset")
    private List<String> chipset;

    @JsonProperty("Memory Slots")
    private List<String> memorySlots;

    @JsonProperty("Part #")
    private List<String> partNumbers;

    @JsonProperty("Supports ECC")
    private List<String> supportsECC;

    @JsonProperty("USB 2.0 Headers")
    private List<String> usb2_0Headers;

    @JsonProperty("Memory Type")
    private List<String> memoryType;

    @JsonProperty("Memory Max")
    private List<String> memoryMax;

    @JsonProperty("Half Mini-PCIe Slots")
    private List<String> halfMiniPCIeSlots;

    @JsonProperty("Form Factor")
    private List<String> formFactor;

    @JsonProperty("Onboard Video")
    private List<String> onboardVideo;

    @JsonProperty("PCIe x1 Slots")
    private List<String> pcieX1Slots;

    @JsonProperty("Manufacturer")
    private List<String> manufacturer;
    
    @JsonProperty("Model")
    private List<String> model;
    
    @JsonProperty("SLI/CrossFire")
    private List<String>crossFire;

    @JsonProperty("Onboard Ethernet")
    private List<String> onboardEthernet;

    @JsonProperty("mSATA Slots")
    private List<String> msataSlots;

    @JsonProperty("Mini-PCIe / mSATA Slots")
    private List<String> miniPCIMiniSataSlots;

    @JsonProperty("PCIe x4 Slots")
    private List<String> pcieX4Slots;

    @JsonProperty("Mini-PCIe Slots")
    private List<String> miniPCISlots;

    @JsonProperty("M.2 Slots")
    private List<String> m2Slots;

    @JsonProperty("Wireless Networking")
    private List<String> wirelessNetworking;

    @JsonProperty("Socket / CPU")
    private List<String> socketCPU;

    @JsonProperty("Color")
    private List<String> color;

    @JsonProperty("PCIe x16 Slots")
    private List<String> pcieX16Slots;

    @JsonProperty("USB 3.2 Gen 1 Headers")
    private List<String> usb3_2Gen1Headers;

    @JsonProperty("USB 3.2 Gen 2 Headers")
    private List<String> usb3_2Gen2Headers;

    @JsonProperty("USB 2.0 Headers (Single Port)")
    private List<String> usb2_0HeadersSinglePort;

    @JsonProperty("SATA 6.0 Gb/s")
    private List<String> sata6_0GbPerS;

    @JsonProperty("Memory Speed")
    private List<String> memorySpeed;

    @JsonProperty("USB 3.2 Gen 2x2 Headers")
    private List<String> usb3_2Gen2x2Headers;

    @JsonProperty("PCI Slots")
    private List<String> pciSlots;

    @JsonProperty("PCIe x8 Slots")
    private List<String> pcieX8Slots;

    @JsonProperty("RAID Support")
    private List<String> raidSupport;

    @JsonProperty("Compatible CPUs")
    private List<Long> compatibleCPUs;

    @JsonProperty("Compatible CPU Coolers")
    private List<Long> compatibleCPUCoolers;

    @JsonProperty("Compatible Cases")
    private List<Long> compatibleCases;

    @JsonProperty("Compatible RAMs")
    private List<Long> compatibleRAMs;

    @JsonProperty("Compatible Internal Hard Drives")
    private List<Long> compatibleInternalHardDrives;

    @JsonProperty("Compatible GPUs")
    private List<Long> compatibleGPUs;
    
    @JsonProperty("UPC Codes")
    private List<String>upcCodes;

	public List<String> getChipset() {
		return chipset;
	}

	public List<String> getMemorySlots() {
		return memorySlots;
	}

	public List<String> getPartNumbers() {
		return partNumbers;
	}

	public List<String> getSupportsECC() {
		return supportsECC;
	}

	public List<String> getUsb2_0Headers() {
		return usb2_0Headers;
	}

	public List<String> getMemoryType() {
		return memoryType;
	}

	public List<String> getMemoryMax() {
		return memoryMax;
	}

	public List<String> getHalfMiniPCIeSlots() {
		return halfMiniPCIeSlots;
	}

	public List<String> getFormFactor() {
		return formFactor;
	}

	public List<String> getOnboardVideo() {
		return onboardVideo;
	}

	public List<String> getPcieX1Slots() {
		return pcieX1Slots;
	}

	public List<String> getManufacturer() {
		return manufacturer;
	}

	public List<String> getModel() {
		return model;
	}

	public List<String> getCrossFire() {
		return crossFire;
	}

	public List<String> getOnboardEthernet() {
		return onboardEthernet;
	}

	public List<String> getMsataSlots() {
		return msataSlots;
	}

	public List<String> getMiniPCIMiniSataSlots() {
		return miniPCIMiniSataSlots;
	}

	public List<String> getPcieX4Slots() {
		return pcieX4Slots;
	}

	public List<String> getMiniPCISlots() {
		return miniPCISlots;
	}

	public List<String> getM2Slots() {
		return m2Slots;
	}

	public List<String> getWirelessNetworking() {
		return wirelessNetworking;
	}

	public List<String> getSocketCPU() {
		return socketCPU;
	}

	public List<String> getColor() {
		return color;
	}

	public List<String> getPcieX16Slots() {
		return pcieX16Slots;
	}

	public List<String> getUsb3_2Gen1Headers() {
		return usb3_2Gen1Headers;
	}

	public List<String> getUsb3_2Gen2Headers() {
		return usb3_2Gen2Headers;
	}

	public List<String> getUsb2_0HeadersSinglePort() {
		return usb2_0HeadersSinglePort;
	}

	public List<String> getSata6_0GbPerS() {
		return sata6_0GbPerS;
	}

	public List<String> getMemorySpeed() {
		return memorySpeed;
	}

	public List<String> getUsb3_2Gen2x2Headers() {
		return usb3_2Gen2x2Headers;
	}

	public List<String> getPciSlots() {
		return pciSlots;
	}

	public List<String> getPcieX8Slots() {
		return pcieX8Slots;
	}

	public List<String> getRaidSupport() {
		return raidSupport;
	}

	public List<Long> getCompatibleCPUs() {
		return compatibleCPUs;
	}

	public List<Long> getCompatibleCPUCoolers() {
		return compatibleCPUCoolers;
	}

	public List<Long> getCompatibleCases() {
		return compatibleCases;
	}

	public List<Long> getCompatibleRAMs() {
		return compatibleRAMs;
	}

	public List<Long> getCompatibleInternalHardDrives() {
		return compatibleInternalHardDrives;
	}

	public List<Long> getCompatibleGPUs() {
		return compatibleGPUs;
	}

	public List<String> getUpcCodes() {
		return upcCodes;
	}
	
    
}

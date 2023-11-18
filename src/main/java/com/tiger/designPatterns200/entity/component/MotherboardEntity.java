package com.tiger.designPatterns200.entity.component;

import java.util.List;

import com.tiger.designPatterns200.model.component.CompatibilityComponent;
import com.tiger.designPatterns200.util.CollectionUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class MotherboardEntity extends ComponentEntity implements CompatibilityComponent {

	

	private List<String> chipset;

	private List<String> memorySlots;

	private List<String> partNumbers;

	private String supportsECC;

	private String memoryType;

	private String memoryMax;

	private List<String> formFactor;

	private String onboardVideo;

	private String manufacturer;

	private String model;

	private String onboardEthernet;

	private List<String> miniPCIMiniSataSlots;

	private List<String> pcieX4Slots;

	private List<String> miniPCISlots;

	private List<String> m2Slots;

	private String wirelessNetworking;

	private List<String> pcieX16Slots;

	private String memorySpeed;

	@ManyToMany
	private List<CpuEntity> compatibleCPUs;

	@ManyToMany
	private List<CoolerEntity> compatibleCPUCoolers;

	@ManyToMany
	private List<CaseEntity> compatibleCases;

	@ManyToMany
	private List<RamEntity> compatibleRAMs;

	@ManyToMany
	private List<StorageEntity> compatibleInternalHardDrives;

	@ManyToMany
	private List<GpuEntity> compatibleGPUs;

	private List<String> upcCodes;

	public List<String> getChipset() {
		return chipset;
	}

	public List<String> getMemorySlots() {
		return memorySlots;
	}

	public List<String> getPartNumbers() {
		return partNumbers;
	}

	public String getSupportsECC() {
		return supportsECC;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public String getMemoryMax() {
		return memoryMax;
	}

	public List<String> getFormFactor() {
		return formFactor;
	}

	public String getOnboardVideo() {
		return onboardVideo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	public String getOnboardEthernet() {
		return onboardEthernet;
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

	public String getWirelessNetworking() {
		return wirelessNetworking;
	}

	public List<String> getPcieX16Slots() {
		return pcieX16Slots;
	}

	public String getMemorySpeed() {
		return memorySpeed;
	}

	


	public List<CpuEntity> getCompatibleCPUs() {
		return compatibleCPUs;
	}

	public void setCompatibleCPUs(List<CpuEntity> compatibleCPUs) {
		this.compatibleCPUs = compatibleCPUs;
	}

	public List<CoolerEntity> getCompatibleCPUCoolers() {
		return compatibleCPUCoolers;
	}

	public void setCompatibleCPUCoolers(List<CoolerEntity> compatibleCPUCoolers) {
		this.compatibleCPUCoolers = compatibleCPUCoolers;
	}

	public List<CaseEntity> getCompatibleCases() {
		return compatibleCases;
	}

	public void setCompatibleCases(List<CaseEntity> compatibleCases) {
		this.compatibleCases = compatibleCases;
	}

	public List<RamEntity> getCompatibleRAMs() {
		return compatibleRAMs;
	}

	public void setCompatibleRAMs(List<RamEntity> compatibleRAMs) {
		this.compatibleRAMs = compatibleRAMs;
	}

	public List<StorageEntity> getCompatibleInternalHardDrives() {
		return compatibleInternalHardDrives;
	}

	public void setCompatibleInternalHardDrives(List<StorageEntity> compatibleInternalHardDrives) {
		this.compatibleInternalHardDrives = compatibleInternalHardDrives;
	}

	public List<GpuEntity> getCompatibleGPUs() {
		return compatibleGPUs;
	}

	public void setCompatibleGPUs(List<GpuEntity> compatibleGPUs) {
		this.compatibleGPUs = compatibleGPUs;
	}

	public List<String> getUpcCodes() {
		return upcCodes;
	}

	

	public void setChipset(List<String> chipset) {
		this.chipset = chipset;
	}

	public void setMemorySlots(List<String> memorySlots) {
		this.memorySlots = memorySlots;
	}

	public void setPartNumbers(List<String> partNumbers) {
		this.partNumbers = partNumbers;
	}

	public void setSupportsECC(String supportsECC) {
		this.supportsECC = supportsECC;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}

	public void setMemoryMax(String memoryMax) {
		this.memoryMax = memoryMax;
	}

	public void setFormFactor(List<String> formFactor) {
		this.formFactor = formFactor;
	}

	public void setOnboardVideo(String onboardVideo) {
		this.onboardVideo = onboardVideo;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setOnboardEthernet(String onboardEthernet) {
		this.onboardEthernet = onboardEthernet;
	}

	public void setMiniPCIMiniSataSlots(List<String> miniPCIMiniSataSlots) {
		this.miniPCIMiniSataSlots = miniPCIMiniSataSlots;
	}

	public void setPcieX4Slots(List<String> pcieX4Slots) {
		this.pcieX4Slots = pcieX4Slots;
	}

	public void setMiniPCISlots(List<String> miniPCISlots) {
		this.miniPCISlots = miniPCISlots;
	}

	public void setM2Slots(List<String> m2Slots) {
		this.m2Slots = m2Slots;
	}

	public void setWirelessNetworking(String wirelessNetworking) {
		this.wirelessNetworking = wirelessNetworking;
	}

	public void setPcieX16Slots(List<String> pcieX16Slots) {
		this.pcieX16Slots = pcieX16Slots;
	}

	public void setMemorySpeed(String memorySpeed) {
		this.memorySpeed = memorySpeed;
	}

	public void setUpcCodes(List<String> upcCodes) {
		this.upcCodes = upcCodes;
	}

	@Override
	public <T extends ComponentEntity> boolean checkCompatibility(Class<T> clazz, long id) {
		if (clazz.equals(CpuEntity.class)) {
			return CollectionUtils.listContainsId(compatibleCPUs, id);
		} else if (clazz.equals(CoolerEntity.class)) {
			return CollectionUtils.listContainsId(compatibleCPUCoolers, id);
		} else if (clazz.equals(CaseEntity.class)) {
			return CollectionUtils.listContainsId(compatibleCases, id);
		} else if (clazz.equals(RamEntity.class)) {
			return CollectionUtils.listContainsId(compatibleRAMs, id);
		} else if (clazz.equals(StorageEntity.class)) {
			return CollectionUtils.listContainsId(compatibleInternalHardDrives, id);
		} else if (clazz.equals(GpuEntity.class)) {
			return CollectionUtils.listContainsId(compatibleGPUs, id);
		} else {
			return false;
		}
	}


}

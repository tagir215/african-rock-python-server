package com.tiger.designPatterns200.entity.component;

import java.util.List;

import com.tiger.designPatterns200.model.component.CompatibilityComponent;
import com.tiger.designPatterns200.util.CollectionUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class GpuEntity extends ComponentEntity implements CompatibilityComponent {


	private String tdp;

	private String externalPower;

	private List<String> chipset;

	private String boostClock;

	private String frameSync;

	private String memory;

	private String totalSlotWidth;

	private String displayPortOutputs;

	private String caseExpansionSlotWidth;

	private List<String> hdmiOutputs;

	private String memoryType;

	private String coreClock;

	private String effectiveMemoryClock;

	private String length;

	private String manufacturer;

	private String model;

	private String interfaceType;

	@ManyToMany
	private List<CaseEntity> compatibleCases;

	@ManyToMany
	private List<PowerUnitEntity> compatiblePowerSupplies;

	public String getTdp() {
		return tdp;
	}

	public void setTdp(String tdp) {
		this.tdp = tdp;
	}

	public String getExternalPower() {
		return externalPower;
	}

	public void setExternalPower(String externalPower) {
		this.externalPower = externalPower;
	}

	public List<String> getChipset() {
		return chipset;
	}

	public void setChipset(List<String> chipset) {
		this.chipset = chipset;
	}

	public String getBoostClock() {
		return boostClock;
	}

	public void setBoostClock(String boostClock) {
		this.boostClock = boostClock;
	}

	public String getFrameSync() {
		return frameSync;
	}

	public void setFrameSync(String frameSync) {
		this.frameSync = frameSync;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getTotalSlotWidth() {
		return totalSlotWidth;
	}

	public void setTotalSlotWidth(String totalSlotWidth) {
		this.totalSlotWidth = totalSlotWidth;
	}

	public String getDisplayPortOutputs() {
		return displayPortOutputs;
	}

	public void setDisplayPortOutputs(String displayPortOutputs) {
		this.displayPortOutputs = displayPortOutputs;
	}

	public String getCaseExpansionSlotWidth() {
		return caseExpansionSlotWidth;
	}

	public void setCaseExpansionSlotWidth(String caseExpansionSlotWidth) {
		this.caseExpansionSlotWidth = caseExpansionSlotWidth;
	}

	public List<String> getHdmiOutputs() {
		return hdmiOutputs;
	}

	public void setHdmiOutputs(List<String> hdmiOutputs) {
		this.hdmiOutputs = hdmiOutputs;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}

	public String getCoreClock() {
		return coreClock;
	}

	public void setCoreClock(String coreClock) {
		this.coreClock = coreClock;
	}

	public String getEffectiveMemoryClock() {
		return effectiveMemoryClock;
	}

	public void setEffectiveMemoryClock(String effectiveMemoryClock) {
		this.effectiveMemoryClock = effectiveMemoryClock;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	



	

	public List<CaseEntity> getCompatibleCases() {
		return compatibleCases;
	}

	public void setCompatibleCases(List<CaseEntity> compatibleCases) {
		this.compatibleCases = compatibleCases;
	}

	public List<PowerUnitEntity> getCompatiblePowerSupplies() {
		return compatiblePowerSupplies;
	}

	public void setCompatiblePowerSupplies(List<PowerUnitEntity> compatiblePowerSupplies) {
		this.compatiblePowerSupplies = compatiblePowerSupplies;
	}

	@Override
	public <T extends ComponentEntity> boolean checkCompatibility(Class<T> clazz, long id) {
		if (clazz.equals(PowerUnitEntity.class)) {
			return CollectionUtils.listContainsId(compatiblePowerSupplies, id);
		} else if (clazz.equals(CaseEntity.class)) {
			return CollectionUtils.listContainsId(compatibleCases, id);
		} else {
			return false;
		}
	}
}
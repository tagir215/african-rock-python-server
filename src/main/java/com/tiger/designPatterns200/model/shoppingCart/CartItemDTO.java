package com.tiger.designPatterns200.model.shoppingCart;

import java.util.Objects;

public class CartItemDTO {
	private long motherboardId;
	private long caseId;
	private long cpuId;
	private long cpuCoolerId;
	private long gpuId;
	private long storageId;
	private long ramId;
	private long powerUnitId;
	private String os;
	private String osVersion;
	private String sessionId;
	

	public long getMotherboardId() {
		return motherboardId;
	}

	public void setMotherboardId(long motherboardId) {
		this.motherboardId = motherboardId;
	}

	public long getCaseId() {
		return caseId;
	}

	public void setCaseId(long caseId) {
		this.caseId = caseId;
	}

	public long getCpuId() {
		return cpuId;
	}

	public void setCpuId(long cpuId) {
		this.cpuId = cpuId;
	}

	public long getCpuCoolerId() {
		return cpuCoolerId;
	}

	public void setCpuCoolerId(long cpuCoolerId) {
		this.cpuCoolerId = cpuCoolerId;
	}

	public long getGpuId() {
		return gpuId;
	}

	public void setGpuId(long gpuId) {
		this.gpuId = gpuId;
	}

	public long getStorageId() {
		return storageId;
	}

	public void setStorageId(long storageId) {
		this.storageId = storageId;
	}

	public long getRamId() {
		return ramId;
	}

	public void setRamId(long ramId) {
		this.ramId = ramId;
	}

	public long getPowerUnitId() {
		return powerUnitId;
	}

	public void setPowerUnitId(long powerUnitId) {
		this.powerUnitId = powerUnitId;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		CartItemDTO other = (CartItemDTO) object;

		return this.motherboardId == other.motherboardId && this.caseId == other.caseId && this.cpuId == other.cpuId
				&& this.cpuCoolerId == other.cpuCoolerId && this.gpuId == other.gpuId
				&& this.storageId == other.storageId && this.ramId == other.ramId
				&& this.powerUnitId == other.powerUnitId && Objects.equals(this.os, other.os)
				&& Objects.equals(this.osVersion, other.osVersion);

	}
}

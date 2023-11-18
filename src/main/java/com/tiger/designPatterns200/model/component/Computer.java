package com.tiger.designPatterns200.model.component;

import java.math.BigDecimal;

import com.tiger.designPatterns200.entity.component.CaseEntity;
import com.tiger.designPatterns200.entity.component.CoolerEntity;
import com.tiger.designPatterns200.entity.component.CpuEntity;
import com.tiger.designPatterns200.entity.component.GpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;
import com.tiger.designPatterns200.entity.component.PowerUnitEntity;
import com.tiger.designPatterns200.entity.component.RamEntity;
import com.tiger.designPatterns200.entity.component.StorageEntity;
import com.tiger.designPatterns200.entity.os.OperatingSystem;

public class Computer implements CompositeComponent {
	private MotherboardEntity motherboard;
	private CaseEntity pcCase;
	private CoolerEntity cpuCooler;
	private CpuEntity cpu;
	private GpuEntity gpu;
	private PowerUnitEntity powerUnit;
	private RamEntity ram;
	private StorageEntity storage;
	private OperatingSystem os;
	private long id;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CaseEntity getPcCase() {
		return pcCase;
	}

	public CoolerEntity getCpuCooler() {
		return cpuCooler;
	}

	public CpuEntity getCpu() {
		return cpu;
	}

	public GpuEntity getGpu() {
		return gpu;
	}

	public MotherboardEntity getMotherboard() {
		return motherboard;
	}

	public PowerUnitEntity getPowerUnit() {
		return powerUnit;
	}

	public RamEntity getRam() {
		return ram;
	}

	public StorageEntity getStorage() {
		return storage;
	}

	public OperatingSystem getOs() {
		return os;
	}

	public static class Builder {
		private Computer computer;

		public Builder() {
			computer = new Computer();
		}

		public Builder withPcCase(CaseEntity pcCase) {
			computer.pcCase = pcCase;
			return this;
		}

		public Builder withCpuCooler(CoolerEntity cpuCooler) {
			computer.cpuCooler = cpuCooler;
			return this;
		}

		public Builder withCpu(CpuEntity cpu) {
			computer.cpu = cpu;
			return this;
		}

		public Builder withGpu(GpuEntity gpu) {
			computer.gpu = gpu;
			return this;
		}

		public Builder withMotherboard(MotherboardEntity motherboard) {
			computer.motherboard = motherboard;
			return this;
		}

		public Builder withPowerUnit(PowerUnitEntity powerUnit) {
			computer.powerUnit = powerUnit;
			return this;
		}

		public Builder withRam(RamEntity ram) {
			computer.ram = ram;
			return this;
		}

		public Builder withStorage(StorageEntity storage) {
			computer.storage = storage;
			return this;
		}

		public Builder withOs(OperatingSystem os) {
			computer.os = os;
			return this;
		}

		public Computer build() {
			return computer;
		}
	}

	public void setMotherboard(MotherboardEntity motherboard) {
		this.motherboard = motherboard;
	}

	public void setPcCase(CaseEntity pcCase) {
		this.pcCase = pcCase;
	}

	public void setCpuCooler(CoolerEntity cpuCooler) {
		this.cpuCooler = cpuCooler;
	}

	public void setCpu(CpuEntity cpu) {
		this.cpu = cpu;
	}

	public void setGpu(GpuEntity gpu) {
		this.gpu = gpu;
	}

	public void setPowerUnit(PowerUnitEntity powerUnit) {
		this.powerUnit = powerUnit;
	}

	public void setRam(RamEntity ram) {
		this.ram = ram;
	}

	public void setStorage(StorageEntity storage) {
		this.storage = storage;
	}

	public void setOs(OperatingSystem os) {
		this.os = os;
	}

	@Override
	public BigDecimal getCombinedPrice() {
		BigDecimal fullPrice = BigDecimal.ZERO;
		fullPrice = fullPrice.add(motherboard.getCombinedPrice());
		fullPrice = fullPrice.add(gpu.getCombinedPrice());
		fullPrice = fullPrice.add(cpuCooler.getCombinedPrice());
		fullPrice = fullPrice.add(cpu.getCombinedPrice());
		fullPrice = fullPrice.add(pcCase.getCombinedPrice());
		fullPrice = fullPrice.add(ram.getCombinedPrice());
		fullPrice = fullPrice.add(storage.getCombinedPrice());
		fullPrice = fullPrice.add(powerUnit.getCombinedPrice());
		return fullPrice;
	}

}

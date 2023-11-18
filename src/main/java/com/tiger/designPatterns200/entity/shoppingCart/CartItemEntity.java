	package com.tiger.designPatterns200.entity.shoppingCart;
	
	import com.tiger.designPatterns200.entity.component.CaseEntity;
	import com.tiger.designPatterns200.entity.component.CoolerEntity;
	import com.tiger.designPatterns200.entity.component.CpuEntity;
	import com.tiger.designPatterns200.entity.component.GpuEntity;
	import com.tiger.designPatterns200.entity.component.MotherboardEntity;
	import com.tiger.designPatterns200.entity.component.PowerUnitEntity;
	import com.tiger.designPatterns200.entity.component.RamEntity;
	import com.tiger.designPatterns200.entity.component.StorageEntity;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.FetchType;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	
	@Entity
	public class CartItemEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String token;
	
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name = "motherboard")
		private MotherboardEntity motherboard;
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name = "case_entity")
		private CaseEntity caseEntity;
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name = "cpu")
		private CpuEntity cpu;
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name = "cooler")
		private CoolerEntity cooler;
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name = "gpu")
		private GpuEntity gpu;
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name = "storage")
		private StorageEntity storage;
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name = "ram")
		private RamEntity ram;
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name = "powerunit")
		private PowerUnitEntity powerUnit;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public MotherboardEntity getMotherboard() {
			return motherboard;
		}
		public void setMotherboard(MotherboardEntity motherboard) {
			this.motherboard = motherboard;
		}
		public CaseEntity getCaseEntity() {
			return caseEntity;
		}
		public void setCaseEntity(CaseEntity caseEntity) {
			this.caseEntity = caseEntity;
		}
		public CpuEntity getCpu() {
			return cpu;
		}
		public void setCpu(CpuEntity cpu) {
			this.cpu = cpu;
		}
		public CoolerEntity getCooler() {
			return cooler;
		}
		public void setCooler(CoolerEntity cooler) {
			this.cooler = cooler;
		}
		public GpuEntity getGpu() {
			return gpu;
		}
		public void setGpu(GpuEntity gpu) {
			this.gpu = gpu;
		}
		public StorageEntity getStorage() {
			return storage;
		}
		public void setStorage(StorageEntity storage) {
			this.storage = storage;
		}
		public RamEntity getRam() {
			return ram;
		}
		public void setRam(RamEntity ram) {
			this.ram = ram;
		}
		public PowerUnitEntity getPowerUnit() {
			return powerUnit;
		}
		public void setPowerUnit(PowerUnitEntity powerUnit) {
			this.powerUnit = powerUnit;
		}
	
		
		
		
	
	}

package com.tiger.designPatterns200.service.component;

import static com.tiger.designPatterns200.util.CollectionUtils.getFromListById;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiger.designPatterns200.entity.component.CaseEntity;
import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.entity.component.CoolerEntity;
import com.tiger.designPatterns200.entity.component.CpuEntity;
import com.tiger.designPatterns200.entity.component.GpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;
import com.tiger.designPatterns200.entity.component.PowerUnitEntity;
import com.tiger.designPatterns200.entity.component.RamEntity;
import com.tiger.designPatterns200.entity.component.StorageEntity;
import com.tiger.designPatterns200.entity.shoppingCart.CartItemEntity;
import com.tiger.designPatterns200.model.component.ComponentCollections;
import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.shoppingCart.CartItemDTO;
import com.tiger.designPatterns200.repository.component.ComponentRepository;

import jakarta.persistence.EntityManager;

/**
 * @author OMISTAJA
 * This class might change a bit...
 */
@Service
public class ComponentService {
	private ComponentRepository componentRepository; 
	private ComponentCollectionsDAO dao;
	
	@Autowired
	private EntityManager entityManager;
	
	/**
	 * @param componentRepository
	 * @param dao
	 */
	public ComponentService(ComponentRepository componentRepository, ComponentCollectionsDAO dao) {
		this.componentRepository = componentRepository;
		this.dao = dao;
	}

	/**
	 * @param dto
	 * @return
	 */
	public Computer createComputerFromDTO(CartItemDTO dto) {
		if(dao.getComponentCollections() == null) {
			return createComputerFromDTOMysql(dto);
		}else {
			return createComputerFromDTOCollection(dto);
		}
	}
	
	/**
	 * @param dto
	 * @return
	 */
	private Computer createComputerFromDTOMysql(CartItemDTO dto) {
	  Optional<ComponentEntity> component0 = componentRepository.findByClassAndId(MotherboardEntity.class, dto.getMotherboardId());
	  entityManager.clear();
	  Optional<ComponentEntity> component1 = componentRepository.findByClassAndId(CaseEntity.class, dto.getCaseId()); 
	  entityManager.clear();
	  Optional<ComponentEntity> component2 = componentRepository.findByClassAndId(CpuEntity.class, dto.getCpuId()); 
	  entityManager.clear();
	  Optional<ComponentEntity> component3 = componentRepository.findByClassAndId(CoolerEntity.class, dto.getCpuCoolerId()); 
	  entityManager.clear();
	  Optional<ComponentEntity> component4 = componentRepository.findByClassAndId(GpuEntity.class, dto.getGpuId()); 
	  entityManager.clear();
	  Optional<ComponentEntity> component5 = componentRepository.findByClassAndId(StorageEntity.class, dto.getStorageId()); 
	  entityManager.clear();
	  Optional<ComponentEntity> component6 = componentRepository.findByClassAndId(RamEntity.class, dto.getRamId()); 
	  entityManager.clear();
	  Optional<ComponentEntity> component7 = componentRepository.findByClassAndId(PowerUnitEntity.class, dto.getPowerUnitId()); 

	    Computer computer = new Computer.Builder()
	            .withMotherboard((MotherboardEntity) component0.orElse(null))
	            .withPcCase((CaseEntity) component1.orElse(null))
	            .withCpu((CpuEntity) component2.orElse(null))
	            .withCpuCooler((CoolerEntity) component3.orElse(null))
	            .withGpu((GpuEntity) component4.orElse(null))
	            .withStorage((StorageEntity) component5.orElse(null))
	            .withRam((RamEntity) component6.orElse(null))
	            .withPowerUnit((PowerUnitEntity) component7.orElse(null))
	            .build();

	    return computer;
	}

	/**
	 * @param dto
	 * @return
	 */
	private Computer createComputerFromDTOCollection(CartItemDTO dto) {
		ComponentCollections cc = dao.getComponentCollections();
	    MotherboardEntity motherboard = (MotherboardEntity) getFromListById(cc.motherboards(), dto.getMotherboardId());
	    CaseEntity pcCase = (CaseEntity) getFromListById(cc.cases(), dto.getCaseId());
	    CpuEntity cpu = (CpuEntity) getFromListById(cc.cpus(), dto.getCpuId());
	    CoolerEntity cpuCooler = (CoolerEntity) getFromListById(cc.coolers(), dto.getCpuCoolerId());
	    GpuEntity gpu = (GpuEntity) getFromListById(cc.gpus(), dto.getGpuId());
	    StorageEntity storage = (StorageEntity) getFromListById(cc.storages(), dto.getStorageId());
	    RamEntity ram = (RamEntity) getFromListById(cc.rams(), dto.getRamId());
	    PowerUnitEntity powerUnit = (PowerUnitEntity) getFromListById(cc.powerUnits(), dto.getPowerUnitId());

	    Computer computer = new Computer.Builder()
	            .withMotherboard(motherboard)
	            .withPcCase(pcCase)
	            .withCpu(cpu)
	            .withCpuCooler(cpuCooler)
	            .withGpu(gpu)
	            .withStorage(storage)
	            .withRam(ram)
	            .withPowerUnit(powerUnit)
	            .build();

	    return computer;
	}

	/**
	 * @param e
	 * @return
	 */
	public Computer createComputerFromCartItem(CartItemEntity e) {
		ComponentCollections cc = dao.getComponentCollections();
		MotherboardEntity motherboard = (MotherboardEntity) getFromListById(cc.motherboards(), e.getMotherboard().getId());
		CaseEntity pcCase = (CaseEntity) getFromListById(cc.cases(), e.getCaseEntity().getId());
		CpuEntity cpu = (CpuEntity) getFromListById(cc.cpus(), e.getCpu().getId());
		CoolerEntity cooler = (CoolerEntity) getFromListById(cc.coolers(), e.getCooler().getId());
		GpuEntity gpu = (GpuEntity) getFromListById(cc.gpus(), e.getGpu().getId());
		StorageEntity storage = (StorageEntity) getFromListById(cc.storages(),e.getStorage().getId());
		RamEntity ram = (RamEntity) getFromListById(cc.rams(),e.getRam().getId());
		PowerUnitEntity powerUnit = (PowerUnitEntity) getFromListById(cc.powerUnits(),e.getPowerUnit().getId());
		
		Computer computer = new Computer.Builder()
			    .withMotherboard(motherboard)
			    .withPcCase(pcCase)
			    .withCpu(cpu)
			    .withCpuCooler(cooler)
			    .withGpu(gpu)
			    .withStorage(storage)
			    .withRam(ram)
			    .withPowerUnit(powerUnit)
			    .build();

		return computer;
	}
	
}

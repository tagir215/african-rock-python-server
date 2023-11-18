package com.tiger.designPatterns200.service.component;

import static com.tiger.designPatterns200.util.CollectionUtils.castList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tiger.designPatterns200.entity.component.CaseEntity;
import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.entity.component.CoolerEntity;
import com.tiger.designPatterns200.entity.component.CpuEntity;
import com.tiger.designPatterns200.entity.component.GpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;
import com.tiger.designPatterns200.entity.component.PowerUnitEntity;
import com.tiger.designPatterns200.entity.component.RamEntity;
import com.tiger.designPatterns200.entity.component.StorageEntity;
import com.tiger.designPatterns200.model.component.ComponentCollections;
import com.tiger.designPatterns200.model.scraperDTOs.CaseDTO;
import com.tiger.designPatterns200.model.scraperDTOs.ComponentDTO;
import com.tiger.designPatterns200.model.scraperDTOs.CpuCoolerDTO;
import com.tiger.designPatterns200.model.scraperDTOs.CpuDTO;
import com.tiger.designPatterns200.model.scraperDTOs.GpuDTO;
import com.tiger.designPatterns200.model.scraperDTOs.MotherboardDTO;
import com.tiger.designPatterns200.model.scraperDTOs.PowerUnitDTO;
import com.tiger.designPatterns200.model.scraperDTOs.RamDTO;
import com.tiger.designPatterns200.model.scraperDTOs.StorageDTO;


/**
 * @author OMISTAJA
 * Maps dto from webscraping into an entity. This class might change to a more compact version
 */
public class DtoMapper {
    
    
    private void setBasicThings(ComponentEntity e, ComponentDTO dto) {
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setPrice(dto.getPrice());
        e.setUrl(dto.getUrl());
    }
    
   
    private List<ComponentEntity> getCompatibleComponents(List<Long>ids,List<ComponentEntity>collection) {
    	HashMap<Long,ComponentEntity>map = new HashMap<>();
    	for(ComponentEntity e : collection) {
    		map.put(e.getId(), e);
    	}
    	List<ComponentEntity>result = new ArrayList<>();
    	for(Long id : ids) {
    		if(map.get(id)!=null) {
    			result.add(map.get(id));
    		}
    	}
    	return result;
    }
    
   

    
    /**
     * @param dto
     * @param collections
     * @return
     */
    public MotherboardEntity dtoToMotherboard(MotherboardDTO dto, ComponentCollections collections) {
        MotherboardEntity e = new MotherboardEntity();
        setBasicThings(e, dto);
        e.setChipset(dto.getChipset());
        e.setManufacturer(dto.getManufacturer().get(0));
        List<ComponentEntity>cases = getCompatibleComponents(dto.getCompatibleCases(),collections.cases());
        List<ComponentEntity>coolers = getCompatibleComponents(dto.getCompatibleCPUCoolers(),collections.coolers());
        List<ComponentEntity>cpus = getCompatibleComponents(dto.getCompatibleCPUs(),collections.cpus());
        List<ComponentEntity>gpus = getCompatibleComponents(dto.getCompatibleGPUs(),collections.gpus());
        List<ComponentEntity>storages = getCompatibleComponents(dto.getCompatibleInternalHardDrives(),collections.storages());
        List<ComponentEntity>rams = getCompatibleComponents(dto.getCompatibleRAMs(),collections.rams());
        e.setCompatibleCases(castList(cases, CaseEntity.class));
        e.setCompatibleCPUCoolers(castList(coolers, CoolerEntity.class));
        e.setCompatibleCPUs(castList(cpus, CpuEntity.class));
        e.setCompatibleGPUs(castList(gpus, GpuEntity.class));
        e.setCompatibleInternalHardDrives(castList(storages, StorageEntity.class));
        e.setCompatibleRAMs(castList(rams, RamEntity.class));
        return e;
    }
    

    public CaseEntity dtoToCase(CaseDTO dto) {
        CaseEntity e = new CaseEntity();
        setBasicThings(e, dto);
        return e;
    }
    

    public CoolerEntity dtoToCooler(CpuCoolerDTO dto) {
        CoolerEntity e = new CoolerEntity();
        setBasicThings(e, dto);
        return e;
    }

    public CpuEntity dtoToCpu(CpuDTO dto) {
        CpuEntity e = new CpuEntity();
        setBasicThings(e, dto);
        return e;
    }
    

    public GpuEntity dtoToGpu(GpuDTO dto, ComponentCollections collections) {
        GpuEntity e = new GpuEntity();
        setBasicThings(e, dto);
        List<ComponentEntity>cases = getCompatibleComponents(dto.getCompatibleCases(),collections.cases());
        List<ComponentEntity>powerUnits = getCompatibleComponents(dto.getCompatiblePowerSupplies(),collections.powerUnits());
        e.setCompatibleCases(castList(cases,CaseEntity.class));
        e.setCompatiblePowerSupplies(castList(powerUnits,PowerUnitEntity.class));
        return e;
    }
    
    public PowerUnitEntity dtoToPowerUnit(PowerUnitDTO dto) {
        PowerUnitEntity e = new PowerUnitEntity();
        setBasicThings(e, dto);
        return e;
    }
    
    public RamEntity dtoToRam(RamDTO dto) {
        RamEntity e = new RamEntity();
        setBasicThings(e, dto);
        return e;
    }
    
    public StorageEntity dtoToStorage(StorageDTO dto) {
        StorageEntity e = new StorageEntity();
        setBasicThings(e, dto);
        return e;
    }
    
    
    

    public List<ComponentEntity> dtoListToMotherboardList(HashMap<String, MotherboardDTO> dtos, ComponentCollections collections) {
        List<ComponentEntity> entities = new ArrayList<>();
        for (MotherboardDTO dto : dtos.values()) {
            MotherboardEntity e = dtoToMotherboard(dto, collections);
            entities.add(e);
        }
        return entities;
    }

    public List<ComponentEntity> dtoListToGpuList(HashMap<String, GpuDTO> dtos, ComponentCollections collections) {
        List<ComponentEntity> entities = new ArrayList<>();
        for (GpuDTO dto : dtos.values()) {
            GpuEntity e = dtoToGpu(dto, collections);
            entities.add(e);
        }
        return entities;
    }

    public List<ComponentEntity> dtoListToCaseList(HashMap<String, CaseDTO> dtos) {
        List<ComponentEntity> entities = new ArrayList<>();
        for (CaseDTO dto : dtos.values()) {
            CaseEntity entity = dtoToCase(dto);
            entities.add(entity);
        }
        return entities;
    }

    public List<ComponentEntity> dtoListToCoolerList(HashMap<String, CpuCoolerDTO> dtos) {
        List<ComponentEntity> entities = new ArrayList<>();
        for (CpuCoolerDTO dto : dtos.values()) {
            CoolerEntity entity = dtoToCooler(dto);
            entities.add(entity);
        }
        return entities;
    }

    public List<ComponentEntity> dtoListToCpuList(HashMap<String, CpuDTO> dtos) {
        List<ComponentEntity> entities = new ArrayList<>();
        for (CpuDTO dto : dtos.values()) {
            CpuEntity entity = dtoToCpu(dto);
            entities.add(entity);
        }
        return entities;
    }

    public List<ComponentEntity> dtoListToRamList(HashMap<String, RamDTO> dtos) {
        List<ComponentEntity> entities = new ArrayList<>();
        for (RamDTO dto : dtos.values()) {
            RamEntity entity = dtoToRam(dto);
            entities.add(entity);
        }
        return entities;
    }

    public List<ComponentEntity> dtoListToStorageList(HashMap<String, StorageDTO> dtos) {
        List<ComponentEntity> entities = new ArrayList<>();
        for (StorageDTO dto : dtos.values()) {
            StorageEntity entity = dtoToStorage(dto);
            entities.add(entity);
        }
        return entities;
    }

    public List<ComponentEntity> dtoListToPowerUnitList(HashMap<String, PowerUnitDTO> dtos) {
        List<ComponentEntity> entities = new ArrayList<>();
        for (PowerUnitDTO dto : dtos.values()) {
            PowerUnitEntity entity = dtoToPowerUnit(dto);
            entities.add(entity);
        }
        return entities;
    }

}

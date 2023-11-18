package com.tiger.designPatterns200.service.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiger.designPatterns200.entity.component.ComponentEntity;
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
import com.tiger.designPatterns200.repository.FileManager;

/**
 * @author OMISTAJA
 * Converting jsons to ComponentCollections record that is used in many sections of the application
 */
@Component
public class ComponentCollectionsDAOJsonImpl implements ComponentCollectionsDAO{
	
	private ComponentCollections collections; 
	
	public ComponentCollections getComponentCollections(){
		if(collections!=null) {
			return collections;
		}
		FileManager fileManager = new FileManager();
		ClassLoader loader = this.getClass().getClassLoader();
		
		String json1 = fileManager.streamToString(loader.getResourceAsStream("realData/motherboards.json"));
		String json2 = fileManager.streamToString(loader.getResourceAsStream("realData/cases.json"));
		String json3 = fileManager.streamToString(loader.getResourceAsStream("realData/cpuCoolers.json"));
		String json4 = fileManager.streamToString(loader.getResourceAsStream("realData/cpus.json"));
		String json5 = fileManager.streamToString(loader.getResourceAsStream("realData/gpus.json"));
		String json6 = fileManager.streamToString(loader.getResourceAsStream("realData/powerSupplies.json"));
		String json7 = fileManager.streamToString(loader.getResourceAsStream("realData/rams.json"));
		String json8 = fileManager.streamToString(loader.getResourceAsStream("realData/storages.json"));
		
		TypeReference<HashMap<String,MotherboardDTO>> type1 = new TypeReference<>() {};
		TypeReference<HashMap<String,CaseDTO>> type2 = new TypeReference<>() {};
		TypeReference<HashMap<String,CpuCoolerDTO>> type3 = new TypeReference<>() {};
		TypeReference<HashMap<String,CpuDTO>> type4 = new TypeReference<>() {};
		TypeReference<HashMap<String,GpuDTO>> type5 = new TypeReference<>() {};
		TypeReference<HashMap<String,PowerUnitDTO>> type6 = new TypeReference<>() {};
		TypeReference<HashMap<String,RamDTO>> type7 = new TypeReference<>() {};
		TypeReference<HashMap<String,StorageDTO>> type8 = new TypeReference<>() {};
		
		List<ComponentDTO>dtos = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			HashMap<String,MotherboardDTO>dtos1 = mapper.readValue(json1, type1);
			HashMap<String,CaseDTO> dtos2 = mapper.readValue(json2, type2);
			HashMap<String,CpuCoolerDTO> dtos3 = mapper.readValue(json3, type3);
			HashMap<String,CpuDTO> dtos4 = mapper.readValue(json4, type4);
			HashMap<String,GpuDTO> dtos5 = mapper.readValue(json5, type5);
			HashMap<String,PowerUnitDTO> dtos6 = mapper.readValue(json6, type6);
			HashMap<String,RamDTO> dtos7 = mapper.readValue(json7, type7);
			HashMap<String,StorageDTO> dtos8 = mapper.readValue(json8, type8);
			
			
			DtoMapper dtoMapper = new DtoMapper();
			ComponentCollections collectionsV1 = new ComponentCollections(
					null,
					dtoMapper.dtoListToCaseList(dtos2),
					dtoMapper.dtoListToCoolerList(dtos3),
					dtoMapper.dtoListToCpuList(dtos4),
					null,
					dtoMapper.dtoListToPowerUnitList(dtos6),
					dtoMapper.dtoListToRamList(dtos7),
					dtoMapper.dtoListToStorageList(dtos8)
					);
			List<ComponentEntity>gpus = dtoMapper.dtoListToGpuList(dtos5, collectionsV1);
			
			ComponentCollections collectionsV2 = new ComponentCollections(
					null,
					collectionsV1.cases(),
					collectionsV1.coolers(),
					collectionsV1.cpus(),
					gpus,
					collectionsV1.powerUnits(),
					collectionsV1.rams(),
					collectionsV1.storages()
					);
			
			List<ComponentEntity>motherboards = dtoMapper.dtoListToMotherboardList(dtos1, collectionsV2);
			
			ComponentCollections collectionsV3 = new ComponentCollections(
					motherboards,
					collectionsV1.cases(),
					collectionsV1.coolers(),
					collectionsV1.cpus(),
					collectionsV2.gpus(),
					collectionsV1.powerUnits(),
					collectionsV1.rams(),
					collectionsV1.storages()
					);
			this.collections = collectionsV3;
			return collectionsV3;
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
}

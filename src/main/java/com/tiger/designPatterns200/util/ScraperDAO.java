package com.tiger.designPatterns200.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 *
 */
public class ScraperDAO {
	
	/**
	 * @return
	 */
	public	List<List<ComponentDTO>> getCollections(){
		String[] paths = new String[] {
				"realData/motherboards.json",
				"realData/cases.json",
				"realData/cpuCoolers.json",
				"realData/cpus.json",
				"realData/gpus.json",
				"realData/powerSupplies.json",
				"realData/rams.json",
				"realData/storages.json"
		};
		
		String[] jsons = pathsToJsons(paths);
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		List<HashMap<String,HashMap<String,Object>>>maps = new ArrayList<>();
		for(String json : jsons) {
			HashMap<String, HashMap<String, Object>> map = null;
			try {
				map = mapper.readValue(json, HashMap.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}	
			maps.add(map);
		}
		
		Class<?>[] classes = new Class<?>[] {
			MotherboardDTO.class,
			CaseDTO.class,
			CpuCoolerDTO.class,
			CpuDTO.class,
			GpuDTO.class,
			PowerUnitDTO.class,
			RamDTO.class,
			StorageDTO.class
		};
		
		List<ComponentDTO>motherboards = hashMapOfHashMapsIntoListOfEntities(maps.get(0),classes[0],mapper);
		List<ComponentDTO>cases = hashMapOfHashMapsIntoListOfEntities(maps.get(1),classes[1],mapper);
		List<ComponentDTO>coolers = hashMapOfHashMapsIntoListOfEntities(maps.get(2),classes[2],mapper);
		List<ComponentDTO>cpus = hashMapOfHashMapsIntoListOfEntities(maps.get(3),classes[3],mapper);
		List<ComponentDTO>gpus = hashMapOfHashMapsIntoListOfEntities(maps.get(4),classes[4],mapper);
		List<ComponentDTO>powers = hashMapOfHashMapsIntoListOfEntities(maps.get(5),classes[5],mapper);
		List<ComponentDTO>rams = hashMapOfHashMapsIntoListOfEntities(maps.get(6),classes[6],mapper);
		List<ComponentDTO>storages = hashMapOfHashMapsIntoListOfEntities(maps.get(7),classes[7],mapper);
		
		List<List<ComponentDTO>>dtos = new ArrayList<>();
		dtos.add(cases);
		dtos.add(coolers);
		dtos.add(cpus);
		dtos.add(powers);
		dtos.add(rams);
		dtos.add(storages);
		dtos.add(gpus);
		dtos.add(motherboards);
		
				
		return dtos;
		
	}
	
	
	
	/**
	 * @param maps
	 * @param clazz
	 * @param mapper
	 * @return
	 */
	private List<ComponentDTO>hashMapOfHashMapsIntoListOfEntities(
			HashMap<String,HashMap<String,Object>>maps, Class<?>clazz, ObjectMapper mapper)
	{
		List<ComponentDTO>entityList = new ArrayList<>();
		for(HashMap<String,Object>map : maps.values()) {
			ComponentDTO e = (ComponentDTO) mapper.convertValue(map, clazz);
			entityList.add(e);
		}
		return entityList;
	}
	
	/**
	 * @param paths
	 * @return
	 */
	private String[] pathsToJsons(String[]paths){
		String[] jsons = new String[paths.length];
		FileManager fileManager = new FileManager();
		ClassLoader loader = this.getClass().getClassLoader();
		for(int i=0; i<paths.length; i++) {
			String path = paths[i];
			jsons[i] = fileManager.streamToString(loader.getResourceAsStream(path));
		}
		return jsons;
	}
	
	
	
	
}

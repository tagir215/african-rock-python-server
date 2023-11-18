package com.tiger.designPatterns200.util;

import java.util.ArrayList;
import java.util.List;

import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.entity.shoppingCart.CartItemEntity;
import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.component.ComputerDTO;
import com.tiger.designPatterns200.model.scraperDTOs.ComponentDTO;

/**
 * @author OMISTAJA
 *
 */
public class ComponentMapper {

	
	/**
	 * @param computer
	 * @return
	 */
	public static ComputerDTO computerToDto(Computer computer) {
		
		List<ComponentDTO>dtos = new ArrayList<>();
		dtos.add(componentToDto(computer.getMotherboard()));
		dtos.add(componentToDto(computer.getPcCase()));
		dtos.add(componentToDto(computer.getGpu()));
		dtos.add(componentToDto(computer.getCpu()));
		dtos.add(componentToDto(computer.getCpuCooler()));
		dtos.add(componentToDto(computer.getRam()));
		dtos.add(componentToDto(computer.getStorage()));
		dtos.add(componentToDto(computer.getPowerUnit()));
		ComputerDTO dto = new ComputerDTO(dtos);
		dto.setCombinedPrice(computer.getCombinedPrice());
		return dto;
	}
	
	/**
	 * @param entity
	 * @return
	 */
	public static ComponentDTO componentToDto(ComponentEntity entity) {
			 ComponentDTO dto = new ComponentDTO();
			 dto.setId(entity.getId());
			 dto.setName(entity.getName());
			 dto.setPrice(entity.getCombinedPrice());
			 dto.setUrl(entity.getUrl());
			 return dto;
	}
	
	
	/**
	 * @param computers
	 * @return
	 */
	public static List<ComputerDTO>computersToDtos(List<Computer>computers){
		List<ComputerDTO>dtos = new ArrayList<>();
		for(Computer e : computers) {
			dtos.add(computerToDto(e));
		}
		return dtos;
	}
	
	/**
	 * @param computer
	 * @return
	 */
	public static CartItemEntity computerToCartItemEntity(Computer computer) {
		
		CartItemEntity e = new CartItemEntity();
		e.setMotherboard(computer.getMotherboard());
		e.setCaseEntity(computer.getPcCase());
		e.setCpu(computer.getCpu());
		e.setCooler(computer.getCpuCooler());
		e.setGpu(computer.getGpu());
		e.setStorage(computer.getStorage());
		e.setRam(computer.getRam());
		e.setPowerUnit(computer.getPowerUnit());
		return e;
	}

	
	
}

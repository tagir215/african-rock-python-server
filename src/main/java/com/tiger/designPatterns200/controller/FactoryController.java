package com.tiger.designPatterns200.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.designPatterns200.exception.factory.FactoryRegistryException;
import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.component.FactoryDTO;
import com.tiger.designPatterns200.repository.computer.ComputerRepository;
import com.tiger.designPatterns200.service.factory.computerFactory.AbstractComputerFactory;
import com.tiger.designPatterns200.service.factory.registry.FactoryRegistry;
import com.tiger.designPatterns200.service.factory.registry.StrategyRegistry;
import com.tiger.designPatterns200.service.factory.strategy.BuildingStrategy;
import com.tiger.designPatterns200.service.factory.strategy.FactoryStrategyContext;
import com.tiger.designPatterns200.util.ComponentMapper;

/**
 * @author OMISTAJA
 * Creates a computer with a factory and a strategy
 */
@RestController
public class FactoryController {
	
	private FactoryStrategyContext context;
	private FactoryRegistry factoryRegistry;
	private StrategyRegistry strategyRegistry;
	private ComputerRepository repository;

	public FactoryController(FactoryStrategyContext context,
			FactoryRegistry factoryRegistry, StrategyRegistry strategyRegistry,
			ComputerRepository repository) {
		this.factoryRegistry = factoryRegistry;
		this.context = context;
		this.strategyRegistry = strategyRegistry;
		this.repository = repository;
	}


	/**
	 * @param resource
	 * @return
	 */
	@PostMapping("api/v1/getComputers/")
	public ResponseEntity<Object> getComputers(@RequestBody FactoryDTO resource) {
		try{
			AbstractComputerFactory factory = factoryRegistry.getFactoryMap().get(resource.getType());
			BuildingStrategy strategy = strategyRegistry.getStrategyMap().get(resource.getTier());
			
			if(factory == null) {
				String errorMessage = "Factory not found for type: "+resource.getType();
				throw new FactoryRegistryException(errorMessage);
			}
			
			if (strategy == null) {
				String errorMessage = "Strategy not found for tier: " + resource.getTier();
				throw new FactoryRegistryException(errorMessage);
			}

			List<Computer>computers = context.executeFactoryStrategy(factory, strategy);
			repository.saveComputers(computers);
			return ResponseEntity.ok(ComponentMapper.computersToDtos(computers));
		}catch (Exception e){
			String errorMessage = "Failed to create computer: " + e.getMessage();
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}
	
	
	
}

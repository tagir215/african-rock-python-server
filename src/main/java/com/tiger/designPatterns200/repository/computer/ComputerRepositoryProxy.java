package com.tiger.designPatterns200.repository.computer;

import java.util.List;

import com.tiger.designPatterns200.model.component.Computer;

/**
 * @author OMISTAJA
 *
 */
public class ComputerRepositoryProxy implements ComputerRepository{

	private  List<Computer>computersChache;
	private final ComputerRepository repository;
	
	
	public ComputerRepositoryProxy(ComputerRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Computer> getAllComputers() {
		if(computersChache==null) {
			return repository.getAllComputers();
		}
		return computersChache;
	}

	@Override
	public Computer getComputerById(long id) {
		if(computersChache==null) {
			return repository.getComputerById(id);
		}
		Computer selectedComputer = null;
		for(Computer e : computersChache) {
			if(e!=null && e.getId()==id) {
				selectedComputer = e;
			}
		}
		return selectedComputer;
	}

	@Override
	public void saveComputers(List<Computer> entities) {
		this.computersChache = entities;
		repository.saveComputers(entities);
		
	}
}

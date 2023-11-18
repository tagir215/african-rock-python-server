package com.tiger.designPatterns200.repository.computer;

import java.util.List;

import com.tiger.designPatterns200.model.component.Computer;

/**
 * @author OMISTAJA
 * returns computer list. Handled with my custom proxy because I wanted a reason to implement the Proxy design pattern somehow
 */
public interface ComputerRepository {
	public List<Computer>getAllComputers();
	public Computer getComputerById(long id);
	public void saveComputers(List<Computer>entities);
}

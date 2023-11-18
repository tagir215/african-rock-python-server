package com.tiger.designPatterns200.repository.computer;

import java.util.List;

import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.repository.annotation.MyTestProxyableAnnotation;

/**
 * @author OMISTAJA
 *
 */
@MyTestProxyableAnnotation
public class ComputerRepositoryImpl implements ComputerRepository {

	@Override
	public List<Computer> getAllComputers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Computer getComputerById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveComputers(List<Computer> entities) {
		// TODO Auto-generated method stub
		
	}


}

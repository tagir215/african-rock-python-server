package com.tiger.designPatterns200.service.component;

import java.util.LinkedList;
import java.util.Queue;

import com.tiger.designPatterns200.entity.os.WindowsOS;
import com.tiger.designPatterns200.exception.factory.ComponentSelectorException;
import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.service.factory.computerFactory.AbstractComputerFactory;
import com.tiger.designPatterns200.service.factory.computerFactory.implementations.BasicComputerFactory;

/**
 * @author OMISTAJA
 * not used in logic for now
 */
public class ComputerPool {
	private Queue<Computer>pool;
	public ComputerPool(Computer computer,int size) {
		pool = new LinkedList<>();
		for(int i=0; i<size; i++) {
			pool.add((Computer)computer);
		}
		
		
	}
	public synchronized Computer getObject() {
		if(pool.isEmpty()) {
			AbstractComputerFactory cFactory = new BasicComputerFactory(null);
			pool.add(cFactory.buildBudgetComputer());
		}
		return pool.poll();
	}
	
	public synchronized void returnObject(Computer computer) {
		pool.add(computer);	
	}
}

package com.tiger.designPatterns200.exception.factory;

public abstract class ComponentSelectorException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ComponentSelectorException(String component) {
		super(component);
	}
}

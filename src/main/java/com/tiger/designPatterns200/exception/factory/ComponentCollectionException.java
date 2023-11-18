package com.tiger.designPatterns200.exception.factory;

public class ComponentCollectionException extends ComponentSelectorException{


	private static final long serialVersionUID = 1L;

	public ComponentCollectionException(String component) {
		super(component+" is null or empty");
	}

}

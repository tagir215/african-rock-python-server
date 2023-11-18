package com.tiger.designPatterns200.exception.factory;

public class NoFittingComponentFoundException extends ComponentSelectorException {

	private static final long serialVersionUID = 1L;

	public NoFittingComponentFoundException(String component) {
		super(component);
	}

}

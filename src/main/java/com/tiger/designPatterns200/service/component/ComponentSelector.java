package com.tiger.designPatterns200.service.component;

import com.tiger.designPatterns200.model.component.SelectedComponents;
import com.tiger.designPatterns200.service.factory.computerFactory.ComputerInfo;

public interface ComponentSelector {
	/**
	 * @param info
	 * @return SelectedComponents record
	 */
	public SelectedComponents selectComponents(ComputerInfo info);
}

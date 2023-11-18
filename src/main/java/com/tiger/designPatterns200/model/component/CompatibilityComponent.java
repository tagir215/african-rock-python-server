package com.tiger.designPatterns200.model.component;

import com.tiger.designPatterns200.entity.component.ComponentEntity;

public interface CompatibilityComponent {
	 public<T extends ComponentEntity> boolean checkCompatibility(Class<T> clazz, long id);
}

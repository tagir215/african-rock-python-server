package com.tiger.designPatterns200.model.component;

import java.util.List;

import com.tiger.designPatterns200.entity.component.ComponentEntity;

public record ComponentCollections(
	List<ComponentEntity> motherboards,
    List<ComponentEntity> cases,
    List<ComponentEntity> coolers,
    List<ComponentEntity> cpus,
    List<ComponentEntity> gpus,
    List<ComponentEntity> powerUnits,
    List<ComponentEntity> rams,
    List<ComponentEntity> storages
) {
	
}

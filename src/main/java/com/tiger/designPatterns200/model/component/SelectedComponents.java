package com.tiger.designPatterns200.model.component;

import com.tiger.designPatterns200.entity.component.CaseEntity;
import com.tiger.designPatterns200.entity.component.CoolerEntity;
import com.tiger.designPatterns200.entity.component.CpuEntity;
import com.tiger.designPatterns200.entity.component.GpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;
import com.tiger.designPatterns200.entity.component.PowerUnitEntity;
import com.tiger.designPatterns200.entity.component.RamEntity;
import com.tiger.designPatterns200.entity.component.StorageEntity;

public record SelectedComponents(
		MotherboardEntity motherboard,
		GpuEntity gpu,
		CaseEntity caseEntity,
		CoolerEntity cooler,
		CpuEntity cpu,
		PowerUnitEntity powerUnit,
		RamEntity ram,
		StorageEntity storage
		) {

}

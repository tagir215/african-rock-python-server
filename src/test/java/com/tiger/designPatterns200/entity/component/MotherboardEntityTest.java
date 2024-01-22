package com.tiger.designPatterns200.entity.component;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MotherboardEntityTest {
	List<CpuEntity>cpus;
	@BeforeEach
	void setup() {
		cpus = new ArrayList();
		var cpu1 = new CpuEntity();
		var cpu2 = new CpuEntity();
		var cpu3 = new CpuEntity();
		var cpu4 = new CpuEntity();
		var cpu5 = new CpuEntity();
		var cpu6 = new CpuEntity();
		cpu1.setId(0L);
		cpu2.setId(2L);
		cpu3.setId(4L);
		cpu4.setId(6L);
		cpu5.setId(8L);
		cpu6.setId(10L);
		cpus.add(cpu1);
		cpus.add(cpu2);
		cpus.add(cpu3);
		cpus.add(cpu4);
		cpus.add(cpu5);
		cpus.add(cpu6);
	}

	@Test
    void testCheckCompatibilityForCpuEntity() {
        MotherboardEntity motherboard = new MotherboardEntity();
        motherboard.setCompatibleCPUs(cpus);
        
        boolean result1 = motherboard.checkCompatibility(CpuEntity.class, 2L);
        boolean result2 = motherboard.checkCompatibility(CpuEntity.class, 3L);
        boolean result3 = motherboard.checkCompatibility(MotherboardEntity.class, 2L);

        assertTrue(result1, "CPU compatibility check failed");
        assertFalse(result2, "should be false");
        assertFalse(result3, "should be cpuEntity class");
    }



}

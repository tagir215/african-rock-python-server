package com.tiger.designPatterns200.service.webscraping;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

class ManualDataManipulatorTest {

	@Test
	void test() {
		InputStream i1 = this.getClass().getClassLoader().getResourceAsStream("realData/cases.json");
		InputStream i2 = this.getClass().getClassLoader().getResourceAsStream("realData/cases2.json");
		String json = ManualDataManipulator.combine(i1, i2);
		System.out.println(json);
	}

}

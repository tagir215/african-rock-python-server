package com.tiger.designPatterns200.entity.component;

import java.util.List;

import jakarta.persistence.Entity;


@Entity
public class PowerUnitEntity extends ComponentEntity {
	

	
    private List<String> pcie12PinConnectors;

    private List<String> molex4PinConnectors;

    private List<String> atx4PinConnectors;

    private List<String> pcie8PinConnectors;

    private String wattage;

    private String modular;

    private List<String> eps8PinConnectors;

    private String type;

    private List<String>sataConnectors;

    private List<String>length;

    private List<String>pcie6PinConnectors;

    private String efficiencyRating;

    private String fanless;

    private String output;

    private String manufacturer;

    private String model;

    private List<String>upcCodes;

    private String efficicency;


    
}

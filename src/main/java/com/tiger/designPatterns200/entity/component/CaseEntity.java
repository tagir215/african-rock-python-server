package com.tiger.designPatterns200.entity.component;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class CaseEntity extends ComponentEntity {
    
    private List<String> formFactors;

    private String frontPanelUSB;

    private List<String>dimensions;
    
    private String volume;

    private String manufacturer;

    private String model;

    private String maximumVideoCardLength;


	
    
}


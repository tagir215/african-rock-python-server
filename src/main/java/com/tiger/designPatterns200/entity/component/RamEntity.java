package com.tiger.designPatterns200.entity.component;

import java.util.List;

import jakarta.persistence.Entity;


@Entity
public class RamEntity extends ComponentEntity {
	

	
    private String pricePerGB;

    private String  speed;

    private List<String> formFactor;

    private String eccRegistered;

    private String voltage;

    private String manufacturer;

    private String timing;

    private String firstWordLatency;

    private List<String> upcCodes;

    
}


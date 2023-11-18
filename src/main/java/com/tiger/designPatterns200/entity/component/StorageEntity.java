package com.tiger.designPatterns200.entity.component;

import java.util.List;

import jakarta.persistence.Entity;


@Entity
public class StorageEntity extends ComponentEntity {
	
    private String pricePerGB;

    private List<String> formFactor;

    private String type;

    private String capacity;

    private String manufacturer;

    private List<String>upcCodes;

    private String interfaceType;

    private String cache;


    
}


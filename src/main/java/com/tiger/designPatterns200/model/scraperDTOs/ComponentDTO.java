package com.tiger.designPatterns200.model.scraperDTOs;

import java.math.BigDecimal;

public class ComponentDTO {
	private long id;
	private String name;
	private BigDecimal price;
	private String url;
	private transient String manufacturer;
	private transient int deliveryTime = (int)(Math.random()*14)+1;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setTransientManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	
		
	
}

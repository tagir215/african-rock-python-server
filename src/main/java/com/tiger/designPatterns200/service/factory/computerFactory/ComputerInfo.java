package com.tiger.designPatterns200.service.factory.computerFactory;

import com.tiger.designPatterns200.model.Prototype;

/**
 * @author OMISTAJA
 */
public class ComputerInfo implements Prototype{
	private float x_case = 0.05f;
	private float x_cooler = 0.05f;
	private float x_cpu = 0.2f;
	private float x_gpu = 0.3f;
	private float x_motherboard = 0.05f;
	private float x_powerUnit = 0.05f;
	private float x_ram = 0.2f;
	private float x_storage = 0.1f;
	private float budget;
	
	
	public void setX_case(float x_case) {
		this.x_case = x_case;
	}
	public void setX_cooler(float x_cooler) {
		this.x_cooler = x_cooler;
	}
	public void setX_cpu(float x_cpu) {
		this.x_cpu = x_cpu;
	}
	public void setX_gpu(float x_gpu) {
		this.x_gpu = x_gpu;
	}
	public void setX_motherboard(float x_motherboard) {
		this.x_motherboard = x_motherboard;
	}
	public void setX_powerUnit(float x_powerUnit) {
		this.x_powerUnit = x_powerUnit;
	}
	public void setX_ram(float x_ram) {
		this.x_ram = x_ram;
	}
	public void setX_storage(float x_storage) {
		this.x_storage = x_storage;
	}
	
	public float getX_case() {
		return x_case;
	}
	public float getX_cooler() {
		return x_cooler;
	}
	public float getX_cpu() {
		return x_cpu;
	}
	public float getX_gpu() {
		return x_gpu;
	}
	public float getX_motherboard() {
		return x_motherboard;
	}
	public float getX_powerUnit() {
		return x_powerUnit;
	}
	public float getX_ram() {
		return x_ram;
	}
	public float getX_storage() {
		return x_storage;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	@Override
	public Prototype clonePrototype() {
		ComputerInfo clone = new ComputerInfo();
		clone.setX_case(x_case);
		clone.setX_cooler(x_cooler);
		clone.setX_cpu(x_cpu);
		clone.setX_gpu(x_gpu);
		clone.setX_motherboard(x_motherboard);
		clone.setX_powerUnit(x_powerUnit);
		clone.setX_ram(x_ram);
		clone.setX_storage(x_storage);
		clone.setBudget(budget);
		return clone;
	}
}
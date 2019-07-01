package com.oop.model;

import com.oop.exception.NotEnoughItemsException;

public abstract class SparePart {
	private String id;
	private float price;
	private int count;
	private String description;
	private String manufacture;
	private String modelNo;
	private String designation;
	private String type;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAvailableCount() {
		return count;
	}
	public void setCount(int availableCount) throws NotEnoughItemsException {
		if(availableCount>=0) {
			this.count = availableCount;
		}else {
			throw new NotEnoughItemsException();
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getType() {
		return type;
	}
	
	protected void setType(String type) {
		this.type = type;
	}	
}

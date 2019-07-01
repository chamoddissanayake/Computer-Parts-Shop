package com.oop.model;

public class Ram extends SparePart {
	private String capacity;
	private String ramType;

	public Ram() {
		super.setType(SparePartCategory.RAM);
	}
	
	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getRamType() {
		return ramType;
	}

	public void setRamType(String ramType) {
		this.ramType = ramType;
	}
	
}

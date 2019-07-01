package com.oop.model;

public class HardDiskDrive extends SparePart {
	
	private String capacity;
	private String rpm;

	public HardDiskDrive() {
		super.setType(SparePartCategory.HDD);
	}
	
	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getRpm() {
		return rpm;
	}

	public void setRpm(String rpm) {
		this.rpm = rpm;
	}
	
}

package com.oop.model;

public class Monitor extends SparePart {
	
	private String screenSize;
	private String technology;
	
	public Monitor() {
		super.setType(SparePartCategory.MONITOR);
	}
	
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	
	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
}

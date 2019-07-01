package com.oop.model;

public class Ups extends SparePart {
	String voltage;
	String ampHour;
	String runTime;
	
	public Ups() {
		super.setType(SparePartCategory.UPS);
	}
	
	public String getVoltage() {
		return voltage;
	}
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getAmpHour() {
		return ampHour;
	}
	public void setAmpHour(String ampHour) {
		this.ampHour = ampHour;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
}

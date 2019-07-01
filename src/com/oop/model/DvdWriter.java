package com.oop.model;

public class DvdWriter extends SparePart {
	
	public DvdWriter() {
		super.setType(SparePartCategory.DVDWRITER);
	}
	private String dvdWriterSpeed;
	private String dvdWriterType;
	
	public String getDvdWriterSpeed() {
		return dvdWriterSpeed;
	}
	public void setDvdWriterSpeed(String dvdWriterSpeed) {
		this.dvdWriterSpeed = dvdWriterSpeed;
	}
	public String getDvdWriterType() {
		return dvdWriterType;
	}
	public void setDvdWriterType(String dvdWriterType) {
		this.dvdWriterType = dvdWriterType;
	}
}

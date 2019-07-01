package com.oop.model;

public class Printer extends SparePart {
	String printerType;
	String sheetSize;
	
	public Printer() {
		super.setType(SparePartCategory.PRINTER);
	}
	
	public String getPrinterType() {
		return printerType;
	}
	public void setPrinterType(String printerType) {
		this.printerType = printerType;
	}
	public String getSheetSize() {
		return sheetSize;
	}
	public void setSheetSize(String sheetSize) {
		this.sheetSize = sheetSize;
	}
	
	
}

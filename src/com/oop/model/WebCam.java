package com.oop.model;

public class WebCam extends SparePart{
	String megaPixel;

	public WebCam() {
		super.setType(SparePartCategory.WEBCAM);
	}
	
	public String getMegaPixel() {
		return megaPixel;
	}

	public void setMegaPixel(String megaPixel) {
		this.megaPixel = megaPixel;
	}
	
}

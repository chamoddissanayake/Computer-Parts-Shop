package com.oop.service.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.oop.exception.NotEnoughItemsException;
import com.oop.exception.UnsupportedSparePartType;
import com.oop.model.DvdWriter;
import com.oop.model.HardDiskDrive;
import com.oop.model.Monitor;
import com.oop.model.Printer;
import com.oop.model.Ram;
import com.oop.model.SparePart;
import com.oop.model.SparePartCategory;
import com.oop.model.Ups;
import com.oop.model.WebCam;
import com.oop.service.SparePartServiceImpl;

public class SparePartFactory {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SparePartServiceImpl.class.getName());
	
	public static SparePart getSparePart(ResultSet resultSet) throws SQLException, UnsupportedSparePartType {
		
		return getSparePart(resultSet.getString("spare_part_id"), resultSet.getString("spare_part_type"), 
				resultSet.getString("designation"), resultSet.getString("description"), 
				resultSet.getString("manufacture"), resultSet.getString("modelNo"), 
				resultSet.getFloat("price"), resultSet.getInt("available_count"), 
				resultSet.getString("screenSize"), resultSet.getString("technology"), 
				resultSet.getString("dvdWriterSpeed"), resultSet.getString("dvdWriterType"), 
				resultSet.getString("hddRPM"), resultSet.getString("hddCapacity"), 
				resultSet.getString("printerType"), resultSet.getString("sheetSize"), 
				resultSet.getString("ramCapacity"), resultSet.getString("ramType"), 
				resultSet.getString("voltage"), resultSet.getString("ampHour"), resultSet.getString("runtime"), 
				resultSet.getString("megaPixel"));
	}
	
	
	public static SparePart getSparePart(String sparePartId,String sparePartType, String designation,String description,String manufacture,String modelNo,
			float price,int avialableCount,
			String screenSize,String technology,
			String dvdWriterSpeed,String dvdWriterType,
			String hddRPM,String hddCapacity,
			String printerType,String sheetSize,
			String ramCapacity,String ramType,
			String voltage, String ampHour, String runtime,
			String megaPixel
			) throws SQLException, UnsupportedSparePartType {
		SparePart sparePart;
		if(SparePartCategory.MONITOR.equals(sparePartType)) {
			sparePart = getMonitor(screenSize,technology);
		}else if(SparePartCategory.DVDWRITER.equals(sparePartType)) { 
			sparePart = getDVDWriter(dvdWriterSpeed,dvdWriterType);
		}else if(SparePartCategory.HDD.equals(sparePartType)) {
			sparePart = getHDD( hddRPM, hddCapacity);
		}else if(SparePartCategory.PRINTER.equals(sparePartType)) {
			sparePart = getPrinter( printerType, sheetSize);
		}else if(SparePartCategory.RAM.equals(sparePartType)) {
			sparePart = getRAM( ramCapacity, ramType);
		}else if(SparePartCategory.UPS.equals(sparePartType)) {
			sparePart = getUPS( voltage,  ampHour,  runtime);
		}else if(SparePartCategory.WEBCAM.equals(sparePartType)) {
			sparePart = getWebCam( megaPixel);
		}
		else {
			log.error("Item type not found.");
			throw new UnsupportedSparePartType("Sparepart type not supported for the name:"+sparePartType);
		}
		//common spare part fields
		sparePart.setPrice(price);
		try {
			sparePart.setCount(avialableCount);
		} catch (NotEnoughItemsException e) {
			log.error(e.getMessage());
		}
		sparePart.setDesignation(designation);
		sparePart.setDescription(description);
		sparePart.setManufacture(manufacture);
		sparePart.setModelNo(modelNo);
		sparePart.setId(sparePartId);
		
		return sparePart;
	}

	private static SparePart getMonitor(String screenSize, String technology) {
		Monitor m = new Monitor();
		m.setScreenSize(screenSize);
		m.setTechnology(technology);
		return m;
	}

	
	private static SparePart getDVDWriter(String dvdWriterSpeed,String dvdWriterType) throws SQLException {
		DvdWriter dw = new DvdWriter();
		dw.setDvdWriterSpeed(dvdWriterSpeed);
		dw.setDvdWriterType(dvdWriterType);
		return dw;
	}
	


	
	private static SparePart getHDD(String hddRPM,String hddCapacity) throws SQLException {
		HardDiskDrive hdd = new HardDiskDrive();
		hdd.setRpm(hddRPM);
		hdd.setCapacity(hddCapacity);
		return hdd;
	}
	
	
	private static SparePart getPrinter(String printerType,String sheetSize) throws SQLException {
		Printer pr = new Printer();
		pr.setPrinterType(printerType);
		pr.setSheetSize(sheetSize);
		return pr;
	}
	

	
	private static SparePart getRAM(String ramCapacity,String ramType) throws SQLException {
		Ram rm = new Ram();
		rm.setCapacity(ramCapacity);
		rm.setRamType(ramType);
		return rm;
	}
	
	
	private static SparePart getUPS(String voltage, String ampHour, String runtime) throws SQLException {
		Ups u = new Ups();
		u.setVoltage(voltage);
		u.setAmpHour(ampHour);
		u.setRunTime(runtime);
		return u;
	}
	

	
	private static SparePart getWebCam(String megaPixel) throws SQLException {
		WebCam wb = new WebCam();
		wb.setMegaPixel(megaPixel);
		return wb;
	}

}

package com.oop.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.oop.exception.DatabaseErrorException;
import com.oop.exception.NotEnoughItemsException;
import com.oop.model.DvdWriter;
import com.oop.model.HardDiskDrive;
import com.oop.model.Monitor;
import com.oop.model.Printer;
import com.oop.model.Ram;
import com.oop.model.SparePart;
import com.oop.model.SparePartCategory;
import com.oop.model.Ups;
import com.oop.model.WebCam;

import com.oop.service.ISparePartService;
import com.oop.service.SparePartServiceImpl;

public class AddSparePartServlet extends HttpServlet {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(AddSparePartServlet.class.getName());
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		SparePart sparePart;
		
		String sparePartCategory = req.getParameter("sparePartType");
		
		if(SparePartCategory.MONITOR.equals(sparePartCategory)) {
			Monitor monitor = new Monitor();
			monitor.setScreenSize(req.getParameter("screenSize"));
			monitor.setTechnology(req.getParameter("technology"));
			sparePart = monitor;
		}else if(SparePartCategory.HDD.equals(sparePartCategory)) {
			HardDiskDrive hdd = new HardDiskDrive();
			hdd.setCapacity(req.getParameter("hddCapacity"));
			hdd.setRpm(req.getParameter("rpm"));
			sparePart = hdd;
		}
		else if(SparePartCategory.RAM.equals(sparePartCategory)) {
			Ram ram = new Ram();
			ram.setCapacity(req.getParameter("ramCapacity"));
			ram.setRamType(req.getParameter("ramType"));
			sparePart = ram;
		}else if(SparePartCategory.PRINTER.equals(sparePartCategory)) {
			Printer printer = new Printer();
			printer.setPrinterType(req.getParameter("printerType"));
			printer.setSheetSize(req.getParameter("sheetSize"));
			sparePart = printer;
		}else if(SparePartCategory.UPS.equals(sparePartCategory)) {
			Ups ups = new Ups();
			ups.setVoltage(req.getParameter("voltage"));
			ups.setAmpHour(req.getParameter("ampHours"));
			ups.setRunTime(req.getParameter("runTime"));
			sparePart = ups;
		}else if(SparePartCategory.DVDWRITER.equals(sparePartCategory)) {
			DvdWriter dvdwriter = new DvdWriter();
			dvdwriter.setDvdWriterSpeed(req.getParameter("dvdWriterSpeed"));
			dvdwriter.setDvdWriterType(req.getParameter("dvdWriterType"));
			sparePart = dvdwriter;
		}else if(SparePartCategory.WEBCAM.equals(sparePartCategory)) {
			WebCam webcam = new WebCam();
			webcam.setMegaPixel(req.getParameter("megaPixel"));
			sparePart= webcam;
		}
			
		else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addSparePartError.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		try {
			sparePart.setCount(Integer.parseInt(req.getParameter("count")) );
		} catch (NumberFormatException e1) {
			log.error("Please enter a number as count",e1);
		} catch (NotEnoughItemsException e1) {
			e1.printStackTrace();
		}
		
		try {
		sparePart.setPrice(Float.parseFloat(req.getParameter("price")));
		}catch(NumberFormatException e1) {
			log.error("Please enter a valid number for price");
		}
		
		sparePart.setDescription(req.getParameter("description"));
		sparePart.setManufacture(req.getParameter("manufacture"));
		sparePart.setModelNo(req.getParameter("modelNo"));
		sparePart.setDesignation(req.getParameter("designation"));

		ISparePartService iSparePartService = new SparePartServiceImpl();
		try {
			iSparePartService.insertSparePart(sparePart);
		} catch (DatabaseErrorException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addSparePartError.jsp");
			dispatcher.forward(req, resp);
			return;
		}

		req.setAttribute("sparePart", sparePart);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addSparePartSuccessfully.jsp");
		dispatcher.forward(req, resp);
	}

}

package com.oop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.exception.DatabaseErrorException;
import com.oop.exception.UnsupportedSparePartType;
import com.oop.service.ISparePartService;
import com.oop.service.SparePartServiceImpl;
import com.oop.service.factory.SparePartFactory;


public class SparePartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 
		 ISparePartService obj = new SparePartServiceImpl();
		 
		 try {
			obj.updateSparePart(SparePartFactory.getSparePart(request.getParameter("sparePartId"),
					request.getParameter("sparePartType"), request.getParameter("designation"), request.getParameter("description"), request.getParameter("manufacture"), request.getParameter("modelNo"), 
					Float.parseFloat(request.getParameter("price")),Integer.parseInt(request.getParameter("count")) ,
					request.getParameter("screenSize"), request.getParameter("technology"),
					request.getParameter("dvdWriterSpeed"), request.getParameter("dvdWriterType"), 
					request.getParameter("rpm"), request.getParameter("hddCapacity"), 
					request.getParameter("printerType"), request.getParameter("sheetSize"), 
					request.getParameter("ramCapacity"), request.getParameter("ramType"), 
					request.getParameter("voltage"), request.getParameter("ampHours"), request.getParameter("runTime"), 
					request.getParameter("megaPixel")));
			
			
		} catch (DatabaseErrorException|UnsupportedSparePartType|SQLException e) {
			e.printStackTrace();
		}
		
		 request.setAttribute("spare_part_id", request.getParameter("sparePartId"));
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/sparePartUpdatedSuccessfully.jsp");
		 dispatcher.forward(request, response);
	}
}

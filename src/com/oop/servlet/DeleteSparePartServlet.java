package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.exception.DatabaseErrorException;
import com.oop.service.ISparePartService;
import com.oop.service.SparePartServiceImpl;


public class DeleteSparePartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	int spare_part_id;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 spare_part_id = Integer.parseInt(request.getParameter("sparePartIdForDelete"));	
		 
		 ISparePartService obj = new SparePartServiceImpl();
		 
		 try {
			obj.deleteSparePart(spare_part_id);
		} catch (DatabaseErrorException e) {
			e.printStackTrace();
		}
		
		 request.setAttribute("spare_part_id", spare_part_id);
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/sparePartDeletedSuccessfully.jsp");
		 dispatcher.forward(request, response);
	}
		
}
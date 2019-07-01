package com.oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.oop.exception.DatabaseErrorException;
import com.oop.model.Search;
import com.oop.model.SparePart;
import com.oop.service.ISparePartService;
import com.oop.service.SparePartServiceImpl;

public class SearchServlet extends HttpServlet {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SearchServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
     	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Search search = new Search();

		search.setKeyword(request.getParameter("searchKeyWord"));
		
		ISparePartService iSparePartService = new SparePartServiceImpl();
		
		try {
			List<SparePart> resultsList =  iSparePartService.searchitem(search);
			log.debug("Loaded resuts from db:"+resultsList.size());
			request.setAttribute("resultsList", resultsList);
			
		} catch (DatabaseErrorException e) {
			e.printStackTrace();
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SearchResults.jsp");
		dispatcher.forward(request, response);
				
	}
}
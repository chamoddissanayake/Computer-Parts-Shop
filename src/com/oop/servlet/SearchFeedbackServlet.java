package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.oop.exception.DatabaseErrorException;
import com.oop.model.Feedback;
import com.oop.service.FeedBackServiceImpl;
import com.oop.service.IFeedBackService;

public class SearchFeedbackServlet extends HttpServlet {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SearchFeedbackServlet.class.getName());
			
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int feedbackIdForUpdate = Integer.parseInt(request.getParameter("feedbackIdForUpdate"));
		
		IFeedBackService iFeedbackService = new FeedBackServiceImpl();
		
		
		try {
			Feedback feedbackObj = iFeedbackService.searchFeedback(feedbackIdForUpdate);
			if(feedbackObj!=null) {
			log.debug("Loaded results from db:");
			request.setAttribute("feedbackObj", feedbackObj);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editFeedback.jsp");
			dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/feedbackError.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch(DatabaseErrorException e) {
			e.printStackTrace();
		}
		
		
	
		
	}

}

package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.exception.DatabaseErrorException;
import com.oop.service.FeedBackServiceImpl;
import com.oop.service.IFeedBackService;

public class EditFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		IFeedBackService feedbackUpdateObj = new FeedBackServiceImpl();
	
		try {
			
			feedbackUpdateObj.updateFeedback(	Integer.parseInt(request.getParameter("feedbackIdForUpdate"))	,
												request.getParameter("customerId")	, 
												request.getParameter("feedbackTopic")  , 
												request.getParameter("feedbackDescription")		);
				
			 
		}catch(DatabaseErrorException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("feedbackIdForUpdate", request.getParameter("feedbackIdForUpdate")); 
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/feedbackEditSuccessfully.jsp");
		dispatcher.forward(request, response);
	}
}

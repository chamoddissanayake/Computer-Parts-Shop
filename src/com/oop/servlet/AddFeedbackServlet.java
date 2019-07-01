package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.exception.DatabaseErrorException;
import com.oop.model.Feedback;
import com.oop.service.FeedBackServiceImpl;
import com.oop.service.IFeedBackService;

public class AddFeedbackServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Feedback feedback = new Feedback();
		
		feedback.setCustomerId(request.getParameter("customerId"));
		feedback.setFeedbackTopic(request.getParameter("feedbackTopic"));
		feedback.setFeedbackDescription(request.getParameter("feedbackDescription"));
		
		IFeedBackService iFeedbackService = new FeedBackServiceImpl();
		try {
			iFeedbackService.insertFeedback(feedback);
		} catch (DatabaseErrorException e) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/feedbackError.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		request.setAttribute("feedback", feedback);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/feedbackSubmittedSuccessfully.jsp");
		dispatcher.forward(request, response);
	}

}

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

public class DeleteFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		int feedback_id;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		feedback_id = Integer.parseInt(request.getParameter("feedbackIdForDelete"));	
		 
		IFeedBackService obj = new FeedBackServiceImpl(); 
	
		
		 try {
			 
			 Feedback tmpObj = obj.searchFeedback(feedback_id);
			 if(tmpObj!=null) {
				 obj.deleteFeedback(feedback_id);
			 }else {
				 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/feedbackError.jsp");
				dispatcher.forward(request, response);

			 }
		} catch (DatabaseErrorException e) {
			e.printStackTrace();

		}
		
		 request.setAttribute("feedback_id", feedback_id);
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/feedbackDeletedSuccessfully.jsp");
		 dispatcher.forward(request, response);
	}

}

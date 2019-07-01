package com.oop.service;

import com.oop.exception.DatabaseErrorException;
import com.oop.model.Feedback;

public interface IFeedBackService {
	void insertFeedback(Feedback feedback) throws DatabaseErrorException;
	
	public void deleteFeedback(int feedbackId) throws DatabaseErrorException;
	
	public void updateFeedback(int feedback_id, String customer_id ,String feedback_topic,String description) throws DatabaseErrorException;
	
	public Feedback searchFeedback(int feedbackIdForUpdate) throws DatabaseErrorException;
}

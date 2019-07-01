package com.oop.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.oop.exception.DatabaseErrorException;
import com.oop.exception.QueryLoadingException;
import com.oop.model.Feedback;
import com.oop.util.*;

public class FeedBackServiceImpl implements IFeedBackService{

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(FeedBackServiceImpl.class.getName());
	
	private static Connection connection;
	
	private static Statement statement;
	
	static {
		//create table or drop if exist
		createTables();
	}

	private PreparedStatement preparedStatement;

	private static void createTables() {
		try {
			//connection = DBConnectionUtil.getDBConnection();
			//statement = connection.createStatement();
			
			//statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLES));
			connection = (Connection) DBConnectionUtil.getDBConnection();
			statement = (Statement) connection.createStatement();
			statement.executeUpdate(QueryUtil.getInstance().feedbackqueryByID(CommonConstants.QUERY_ID_CREATE_FEEDBACK_TABLES));
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error(e.getMessage());
			throw new RuntimeException("Error creating tables",e);
		}finally {
			/*
			 * Close statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error(e.getMessage());
			}
		}
		
	}
	
	@Override
	public void insertFeedback(Feedback feedback) throws DatabaseErrorException {
		if(feedback instanceof Feedback) {
			insertFeedbackToDB(feedback);
		}else {
			log.error("Insert feedback error");
		}
		
	}

	private void insertFeedbackToDB(Feedback feedback) throws DatabaseErrorException {
		
		log.debug("Inserting feedback to the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.getInstance().feedbackqueryByID(CommonConstants.QUERY_ID_INSERT_FEEDBACK));
		
			connection.setAutoCommit(false);
			
			//column order
			//					 1            2            3     
			//  feedback_id ,customer_id,feedback_topic,description

			preparedStatement.setString(1, feedback.getCustomerId());
			preparedStatement.setString(2, feedback.getFeedbackTopic());
			preparedStatement.setString(3, feedback.getFeedbackDescription());
			
			// Add Feedback
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException | QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting feedback to the db",e);
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}
		 
	}

	@Override
	public void deleteFeedback(int feedbackId) throws DatabaseErrorException {
		
		log.debug("deleting feedback from database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().feedbackqueryByID(CommonConstants.QUERY_ID_DELETE_FEEDBACK));
			connection.setAutoCommit(false);
			
			//column order
			//					1           
			//			  feedback_id

			
			preparedStatement.setInt(1,feedbackId );
			
			// Delete row
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while deleting the feedback from the db",e);
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}
		
	}
	
	
	
	
	public void updateFeedback(int feedback_id, String customer_id ,String feedback_topic,String description) throws DatabaseErrorException
	{
		log.debug("Updating in the database");
		
		try {
			
			connection = (Connection) DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().feedbackqueryByID(CommonConstants.QUERY_ID_UPDATE_FEEDBACK));
			connection.setAutoCommit(false);
			
			//column order
			// 1			|2			|3				|4			
			//feedback_id	|customer_id|feedback_topic	|description

			try {
				
				preparedStatement.setString(1, customer_id);
				preparedStatement.setString(2, feedback_topic);
				preparedStatement.setString(3, description);
				preparedStatement.setInt(4, feedback_id);
				
				preparedStatement.execute();
				connection.commit();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting DVD Writer record to the db",e);
		}
		finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}
		
	}

	@Override
	public Feedback searchFeedback(int feedbackIdForUpdate) throws DatabaseErrorException {
		
		Feedback fbObj =null;
		
		log.debug("Checking in the database");
		try {
			connection = (Connection) DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().feedbackqueryByID(CommonConstants.QUERY_FEEDBACK_SEARCH);
			log.debug("Executing query:"+query);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, feedbackIdForUpdate);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			//while loop
			while (rs.next()) {
				fbObj = new Feedback();
				fbObj.setCustomerId(rs.getString("customer_id"));
				fbObj.setFeedbackDescription(rs.getString("description"));
				fbObj.setFeedbackTopic(rs.getString("feedback_topic"));
				fbObj.setFeedbackId(feedbackIdForUpdate);
			}
		
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while getting search record from the db",e);
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.error( e.getMessage());
			}
		}
		return fbObj;


	}
	
}

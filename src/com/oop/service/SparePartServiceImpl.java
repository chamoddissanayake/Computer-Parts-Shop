package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.oop.exception.DatabaseErrorException;
import com.oop.exception.QueryLoadingException;
import com.oop.exception.UnsupportedSparePartType;
import com.oop.model.DvdWriter;
import com.oop.model.HardDiskDrive;
import com.oop.model.Monitor;
import com.oop.model.Printer;
import com.oop.model.Ram;
import com.oop.model.Search;
import com.oop.model.SparePart;
import com.oop.model.SparePartCategory;
import com.oop.model.Ups;
import com.oop.model.WebCam;
import com.oop.service.factory.SparePartFactory;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class SparePartServiceImpl implements ISparePartService{

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SparePartServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createTables();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Employees table in the database and
	 * recreate table structure to insert employee entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */
	public static void createTables() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_CREATE_TABLES));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error(e.getMessage());
			throw new RuntimeException("Error creating table",e);
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
				log.error( e.getMessage());
			}
		}
	}

	
	
	@Override
	public void insertSparePart(SparePart sparePart) throws DatabaseErrorException {
		if(sparePart instanceof HardDiskDrive) {
			insertHDD((HardDiskDrive)sparePart);
		}else if(sparePart instanceof Ram) {
			insertRAM((Ram)sparePart);
		}else if(sparePart instanceof Monitor) {
			insertMonitor((Monitor)sparePart);
		}else if(sparePart instanceof Printer) {
			 insertPrinter((Printer)sparePart); 
		}else if(sparePart instanceof Ups) {
			insertUPS((Ups)sparePart);
		}else if(sparePart instanceof DvdWriter){
			insertDVDWriter((DvdWriter)sparePart);
		}else if(sparePart instanceof WebCam){
			insertWebCam((WebCam)sparePart);
		}
		
		else {
			log.error("Spare part instance type not supported yet!");
		}
	}


	/* Insert HDD to database - start */
	
	private void insertHDD(HardDiskDrive hdd) throws DatabaseErrorException {
		log.debug("Inserting HDD to the database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_INSERT_SPARE_PART_HDD));
			connection.setAutoCommit(false);
			
			//column order
			//					1         2             3             4                5             6          7           8          9  
			//	spare_part_id, price,designation, available_count, spare_part_type, description, manufacture, modelNo, hddCapacity, hddRPM

			preparedStatement.setFloat(1, hdd.getPrice());
			preparedStatement.setString(2, hdd.getDesignation());
			preparedStatement.setInt(3, hdd.getAvailableCount());
			preparedStatement.setString(4,SparePartCategory.HDD );
			preparedStatement.setString(5,hdd.getDescription());
			preparedStatement.setString(6,hdd.getManufacture());
			preparedStatement.setString(7,hdd.getModelNo());
			preparedStatement.setString(8,hdd.getCapacity());
			preparedStatement.setString(9,hdd.getRpm());
			
			// Add HDD
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting HDD record to the db",e);
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
	
	/* Insert HDD to database - end */
	
	/* Insert Monitor to database - start */
	
	private void insertMonitor(Monitor monitor) throws DatabaseErrorException {
		log.debug("Inserting Monitor to the database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_INSERT_SPARE_PART_MONITOR));
			connection.setAutoCommit(false);
			
		//	preparedStatement.setFloat(1, hdd.getPrice());
			//column order
			//					1         2             3             4                5             6          7           8          9  
			//	spare_part_id, price,designation, available_count, spare_part_type, description, manufacture, modelNo, screenSize, technology
			preparedStatement.setFloat(1, monitor.getPrice());
			preparedStatement.setString(2, monitor.getDesignation());
			preparedStatement.setInt(3, monitor.getAvailableCount());
			preparedStatement.setString(4, SparePartCategory.MONITOR);
			preparedStatement.setString(5, monitor.getDescription());
			preparedStatement.setString(6, monitor.getManufacture());
			preparedStatement.setString(7, monitor.getModelNo());
			preparedStatement.setString(8, monitor.getScreenSize());
			preparedStatement.setString(9, monitor.getTechnology());

			// Add Monitor
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting Monitor record to the db",e);
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
	
	/* Insert Monitor to database - end */


/* Insert RAM to database - start */
	
	private void insertRAM(Ram ram) throws DatabaseErrorException {
		log.debug("Inserting Ram to the database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_INSERT_SPARE_PART_RAM));
			connection.setAutoCommit(false);
			
			//column order
			//					1         2             3             4                5             6          7           8          9  
			//	spare_part_id, price,designation, available_count, spare_part_type, description, manufacture, modelNo, ramCapacity, ramType

			preparedStatement.setFloat(1, ram.getPrice());
			preparedStatement.setString(2, ram.getDesignation());
			preparedStatement.setInt(3, ram.getAvailableCount());
			preparedStatement.setString(4,SparePartCategory.RAM);
			preparedStatement.setString(5,ram.getDescription());
			preparedStatement.setString(6,ram.getManufacture());
			preparedStatement.setString(7,ram.getModelNo());
			preparedStatement.setString(8,ram.getCapacity());
			preparedStatement.setString(9,ram.getRamType());
			
			// Add RAM
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting RAM record to the db",e);
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
	
	/* Insert RAM to database - end */
	
	
/* Insert Printer to database - start */
	
	private void insertPrinter(Printer printer) throws DatabaseErrorException {
		log.debug("Inserting Printer to the database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_INSERT_SPARE_PART_PRINTER));
			connection.setAutoCommit(false);
			
			//column order
			//					1         2             3             4                5             6          7           8          9  
			//	spare_part_id, price,designation, available_count, spare_part_type, description, manufacture, modelNo, printerType, sheetSize

			preparedStatement.setFloat(1, printer.getPrice());
			preparedStatement.setString(2, printer.getDesignation());
			preparedStatement.setInt(3, printer.getAvailableCount());
			preparedStatement.setString(4,SparePartCategory.PRINTER);
			preparedStatement.setString(5,printer.getDescription());
			preparedStatement.setString(6,printer.getManufacture());
			preparedStatement.setString(7,printer.getModelNo());
			preparedStatement.setString(8,printer.getPrinterType());
			preparedStatement.setString(9,printer.getSheetSize());
			
			// Add Printer
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting Printer record to the db",e);
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
	
	/* Insert Printer to database - end */
	

/* Insert UPS to database - start */
	
	private void insertUPS(Ups ups) throws DatabaseErrorException {
		log.debug("Inserting UPS to the database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_INSERT_SPARE_PART_UPS));
			connection.setAutoCommit(false);
			
			//column order
			//					1         2             3             4                5             6          7         8        9        10
			//	spare_part_id, price,designation, available_count, spare_part_type, description, manufacture, modelNo, voltage, ampHours, runtime

			preparedStatement.setFloat(1, ups.getPrice());
			preparedStatement.setString(2, ups.getDesignation());
			preparedStatement.setInt(3, ups.getAvailableCount());
			preparedStatement.setString(4,SparePartCategory.UPS);
			preparedStatement.setString(5,ups.getDescription());
			preparedStatement.setString(6,ups.getManufacture());
			preparedStatement.setString(7,ups.getModelNo());
			preparedStatement.setString(8,ups.getVoltage());
			preparedStatement.setString(9,ups.getAmpHour());
			preparedStatement.setString(10,ups.getRunTime());
			
			// Add Printer
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting UPS record to the db",e);
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
	
	/* Insert UPS to database - end */

	

	/* Insert DVD Writer to database - start */
	
	private void insertDVDWriter(DvdWriter dvdwriter) throws DatabaseErrorException {
		log.debug("Inserting DVD Writer to the database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_INSERT_SPARE_PART_DVDWRITER));
			connection.setAutoCommit(false);
			
			//column order
			//					1         2             3             4                5             6          7           8                 9   
			//	spare_part_id, price,designation, available_count, spare_part_type, description, manufacture, modelNo, dvdWriterSpeed,  dvdWriterSpeed

			preparedStatement.setFloat(1, dvdwriter.getPrice());
			preparedStatement.setString(2, dvdwriter.getDesignation());
			preparedStatement.setInt(3, dvdwriter.getAvailableCount());
			preparedStatement.setString(4,SparePartCategory.DVDWRITER);
			preparedStatement.setString(5,dvdwriter.getDescription());
			preparedStatement.setString(6,dvdwriter.getManufacture());
			preparedStatement.setString(7,dvdwriter.getModelNo());
			preparedStatement.setString(8,dvdwriter.getDvdWriterSpeed());
			preparedStatement.setString(9,dvdwriter.getDvdWriterType());
			
			// Add Printer
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting DVD Writer record to the db",e);
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
	
	/* Insert DVD Writer to database - end */
	


	/* Insert WebCam to database - start */
	
	private void insertWebCam(WebCam webcam) throws DatabaseErrorException {
		log.debug("Inserting WebCam to the database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_INSERT_SPARE_PART_WEBCAM));
			connection.setAutoCommit(false);
			
			//column order
			//					1         2             3             4                5             6          7           8    
			//	spare_part_id, price,designation, available_count, spare_part_type, description, manufacture, modelNo, megaPixel

			preparedStatement.setFloat(1, webcam.getPrice());
			preparedStatement.setString(2, webcam.getDesignation());
			preparedStatement.setInt(3, webcam.getAvailableCount());
			preparedStatement.setString(4,SparePartCategory.WEBCAM);
			preparedStatement.setString(5,webcam.getDescription());
			preparedStatement.setString(6,webcam.getManufacture());
			preparedStatement.setString(7,webcam.getModelNo());
			preparedStatement.setString(8,webcam.getMegaPixel());
			
			// Add Printer
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while persisting WebCam record to the db",e);
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
	/* Insert WebCam to database - end */
	
	
	public void deleteSparePart(int partIdForDelete) throws DatabaseErrorException {
		/* Delete from database - start */
		
		log.debug("deleting from database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_DELETE_SPAREPART));
			connection.setAutoCommit(false);
			
			//column order
			//					1           
			//			  spare_part_id

			
			preparedStatement.setInt(1,partIdForDelete );
			
			// Delete row
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while deleting the record from the db",e);
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
		
		
		/* Delete from database - end */
		
	}

	
	
	public  List<SparePart>  searchitem(Search search) throws DatabaseErrorException{
	
		List<SparePart> sparePart = new LinkedList<>();

		/*Check search start */
		
		log.debug("Checking in the database");
		try {
			connection = DBConnectionUtil.getDBConnection();

			String query = QueryUtil.getInstance().queryByID(CommonConstants.QUERY_SEARCH);
			log.debug("Executing query:"+query);
			preparedStatement = connection
					.prepareStatement(query);
			
			//column order
			//					1            2           3            
			//			spare_part_type, description, manufacture

			preparedStatement.setString(1, "%"+search.getKeyword()+"%");
			preparedStatement.setString(2, "%"+search.getKeyword()+"%");
			preparedStatement.setString(3, "%"+search.getKeyword()+"%");
		
				
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//while loop
			while (resultSet.next()) {
				sparePart.add(SparePartFactory.getSparePart(resultSet));
			}
			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException|UnsupportedSparePartType e) {
			log.error( e.getMessage());
			throw new DatabaseErrorException("Error while getting search record from the db",e);
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
		
		return sparePart;

		
	}
	
	
	
	public void updateSparePart(SparePart sparePart) throws DatabaseErrorException{
		{
			log.debug("Updating in the database");
			try {
				connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.getInstance().queryByID(CommonConstants.QUERY_ID_UPDATE_SPAREPART));
				connection.setAutoCommit(false);
				
				//column order
				// 1		|2			|3				|4			|5			|6
				//price		|designation|available_count|description|manufacture|modelNo

				//7				|8
				//hddCapacity	|hddRPM
				//9		|10
				//screenSize|technology
				//11			|12
				//ramCapacity	|ramType
				//13			|14
				//printerType	|sheetSize
				//15		|16		|17
				//voltage	|ampHour|runtime
				//18			|19
				//dvdWriterSpeed|dvdWriterType
				//20
				//megaPixel
				//21
				//spare_part_id


				preparedStatement.setFloat(1, sparePart.getPrice());
				preparedStatement.setString(2, sparePart.getDesignation());
				preparedStatement.setInt(3, sparePart.getAvailableCount());
				preparedStatement.setString(4,sparePart.getDescription());
				preparedStatement.setString(5,sparePart.getManufacture());
				preparedStatement.setString(6,sparePart.getModelNo());
				
				if(sparePart instanceof HardDiskDrive) {
					HardDiskDrive hdd = (HardDiskDrive)sparePart;
					preparedStatement.setString(7,hdd.getCapacity());
					preparedStatement.setString(8,hdd.getRpm());
					
					fillNulls(preparedStatement, 9);
					fillNulls(preparedStatement, 10);
					fillNulls(preparedStatement, 11);
					fillNulls(preparedStatement, 12);
					fillNulls(preparedStatement, 13);
					fillNulls(preparedStatement, 14);
					fillNulls(preparedStatement, 15);
					fillNulls(preparedStatement, 16);
					fillNulls(preparedStatement, 17);
					fillNulls(preparedStatement, 18);
					fillNulls(preparedStatement, 19);
					fillNulls(preparedStatement, 20);
					
				}else if(sparePart instanceof Ram) {
					Ram ram = (Ram)sparePart;
					
					preparedStatement.setString(11,ram.getCapacity());
					preparedStatement.setString(12,ram.getRamType());
					fillNulls(preparedStatement, 7);
					fillNulls(preparedStatement, 8);
					fillNulls(preparedStatement, 9);
					fillNulls(preparedStatement, 10);
					fillNulls(preparedStatement, 13);
					fillNulls(preparedStatement, 14);
					fillNulls(preparedStatement, 15);
					fillNulls(preparedStatement, 16);
					fillNulls(preparedStatement, 17);
					fillNulls(preparedStatement, 18);
					fillNulls(preparedStatement, 19);
					fillNulls(preparedStatement, 20);
					
				}else if(sparePart instanceof Monitor) {
					Monitor monitor= (Monitor)sparePart;
					preparedStatement.setString(9,monitor.getScreenSize());
					preparedStatement.setString(10,monitor.getTechnology());
					
					fillNulls(preparedStatement, 7);
					fillNulls(preparedStatement, 8);
					fillNulls(preparedStatement, 11);
					fillNulls(preparedStatement, 12);
					fillNulls(preparedStatement, 13);
					fillNulls(preparedStatement, 14);
					fillNulls(preparedStatement, 15);
					fillNulls(preparedStatement, 16);
					fillNulls(preparedStatement, 17);
					fillNulls(preparedStatement, 18);
					fillNulls(preparedStatement, 19);
					fillNulls(preparedStatement, 20);
					
				}else if(sparePart instanceof Printer) {
					Printer printer =(Printer)sparePart; 
					preparedStatement.setString(13,printer.getPrinterType());
					preparedStatement.setString(14,printer.getSheetSize());
					
					fillNulls(preparedStatement, 7);
					fillNulls(preparedStatement, 8);
					fillNulls(preparedStatement, 9);
					fillNulls(preparedStatement, 10);
					fillNulls(preparedStatement, 11);
					fillNulls(preparedStatement, 12);
					fillNulls(preparedStatement, 15);
					fillNulls(preparedStatement, 16);
					fillNulls(preparedStatement, 17);
					fillNulls(preparedStatement, 18);
					fillNulls(preparedStatement, 19);
					fillNulls(preparedStatement, 20);
					
				}else if(sparePart instanceof Ups) {
					Ups ups = (Ups)sparePart;
					
					preparedStatement.setString(15,ups.getVoltage());
					preparedStatement.setString(16,ups.getAmpHour());
					preparedStatement.setString(17,ups.getRunTime());
					fillNulls(preparedStatement, 7);
					fillNulls(preparedStatement, 8);
					fillNulls(preparedStatement, 9);
					fillNulls(preparedStatement, 10);
					fillNulls(preparedStatement, 11);
					fillNulls(preparedStatement, 12);
					fillNulls(preparedStatement, 13);
					fillNulls(preparedStatement, 14);
					fillNulls(preparedStatement, 18);
					fillNulls(preparedStatement, 19);
					fillNulls(preparedStatement, 20);

				}else if(sparePart instanceof DvdWriter){
					DvdWriter dvdWriter = (DvdWriter)sparePart;
					preparedStatement.setString(18,dvdWriter.getDvdWriterSpeed());
					preparedStatement.setString(19,dvdWriter.getDvdWriterType());
					
					fillNulls(preparedStatement, 7);
					fillNulls(preparedStatement, 8);
					fillNulls(preparedStatement, 9);
					fillNulls(preparedStatement, 10);
					fillNulls(preparedStatement, 11);
					fillNulls(preparedStatement, 12);
					fillNulls(preparedStatement, 13);
					fillNulls(preparedStatement, 14);
					fillNulls(preparedStatement, 15);
					fillNulls(preparedStatement, 16);
					fillNulls(preparedStatement, 17);
					fillNulls(preparedStatement, 20);
					
				}else if(sparePart instanceof WebCam){
					WebCam webCam = (WebCam)sparePart;
					preparedStatement.setString(20,webCam.getMegaPixel());
					
					fillNulls(preparedStatement, 7);
					fillNulls(preparedStatement, 8);
					fillNulls(preparedStatement, 9);
					fillNulls(preparedStatement, 10);
					fillNulls(preparedStatement, 11);
					fillNulls(preparedStatement, 12);
					fillNulls(preparedStatement, 13);
					fillNulls(preparedStatement, 14);
					fillNulls(preparedStatement, 15);
					fillNulls(preparedStatement, 16);
					fillNulls(preparedStatement, 17);
					fillNulls(preparedStatement, 18);
					fillNulls(preparedStatement, 19);

				}
				
				preparedStatement.setString(21,sparePart.getId());
				
				// update SparePart 
				preparedStatement.execute();
				connection.commit();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException|QueryLoadingException e) {
				log.error( e.getMessage());
				throw new DatabaseErrorException("Error while persisting DVD Writer record to the db",e);
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
		
	}

	private void fillNulls(PreparedStatement preparedStatement, int i) throws SQLException {
		preparedStatement.setObject(i, null);
		
	}

	
}


package com.oop.util;


public class CommonConstants {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";
	
	/** Constant for config.properties key for Feedback query file path */
	public static final String FEEDBACK_QUERY_XML = "feedbackQueryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of create_tables in SparePartsQueries.xml */
	public static final String QUERY_ID_CREATE_TABLES = "create_tables";
	
	/** Constant for query id of create_feedback_tables in SparePartsQueries.xml */
	public static final String QUERY_ID_CREATE_FEEDBACK_TABLES = "create_feedback_tables";
	
	public static final String QUERY_ID_INSERT_FEEDBACK		 		= "insert_feedback";
	
	public static final String QUERY_ID_INSERT_SPARE_PART_HDD 		= "insert_spare_part_hdd";
	public static final String QUERY_ID_INSERT_SPARE_PART_MONITOR	= "insert_spare_part_monitor";
	public static final String QUERY_ID_INSERT_SPARE_PART_RAM 		= "insert_spare_part_ram";
	public static final String QUERY_ID_INSERT_SPARE_PART_PRINTER 	= "insert_spare_part_printer";
	public static final String QUERY_ID_INSERT_SPARE_PART_UPS 		= "insert_spare_part_ups";
	public static final String QUERY_ID_INSERT_SPARE_PART_DVDWRITER = "insert_spare_part_dvdwriter";
	public static final String QUERY_ID_INSERT_SPARE_PART_WEBCAM 	= "insert_spare_part_webcam";
	
	public static final String QUERY_ID_UPDATE_SPAREPART 			= "update_spare_part";
	
	public static final String QUERY_ID_DELETE_SPAREPART 			= "delete_spare_part";
	public static final String QUERY_ID_DELETE_FEEDBACK 			= "delete_feedback";
	
	public static final String QUERY_SEARCH  = "searchSparepart";
	public static final String QUERY_FEEDBACK_SEARCH  = "feedbackSearch";
	
	public static final String QUERY_ID_UPDATE_FEEDBACK = "updateFeedback";

	
	/** Constant for query tag in SparePartQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in SparePartQuery.xml */
	public static final String ATTRIB_ID = "id";
	

}

package com.oop.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.oop.exception.QueryLoadingException;


public class QueryUtil extends CommonUtil {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(QueryUtil.class.getName());
	
	private static QueryUtil SINGLE_INSTANCE = null;
	
	private NodeList sparePartsNodeList;
	private NodeList feedBackNodeList;

	
    private QueryUtil() throws QueryLoadingException {
    	
		
		try {
			/*
			 * Read the SparePartsQuery.xml file and read each query node into node
			 * list. It refers tag name query
			 */
			sparePartsNodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(QueryUtil.class.getResourceAsStream("SparePartsQuery.xml"))
						.getElementsByTagName(CommonConstants.TAG_NAME);
			/*
			 * Read the FeedbackQuery.xml file and read each query node into node
			 * list. It refers tag name query
			 */
			
			feedBackNodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(QueryUtil.class.getResourceAsStream("FeedbackQuery.xml"))
						.getElementsByTagName(CommonConstants.TAG_NAME);
		} catch (SAXException | IOException |ParserConfigurationException  e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new QueryLoadingException("Error loading queries from files",e);
		}
    }
    
    public static QueryUtil getInstance() throws QueryLoadingException {
        if (SINGLE_INSTANCE == null) {  
          synchronized(QueryUtil.class) {
        	  if (SINGLE_INSTANCE == null) {
                  SINGLE_INSTANCE = new QueryUtil();
              }
          }
        }
        return SINGLE_INSTANCE;
    }

	/**
	 * This method read the SparePartQuery.xml file and retrieve the query by
	 * query id.
	 * 
	 * @param id
	 *            QueryID to retrieve elements
	 * 
	 * @return String formatted query will be returned as output
	 * 
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws IOException
	 *             - This class is the general class of exceptions produced by
	 *             failed or interrupted I/O operations.
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning.
	 * @throws QueryLoadingException 
	 * 
	 * 
	 */
	public String queryByID(String id) throws SAXException, IOException, ParserConfigurationException, QueryLoadingException {
		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < sparePartsNodeList.getLength(); value++) {
			Element element = (Element) sparePartsNodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				return element.getTextContent().trim();
		}
		throw new QueryLoadingException("Query not found for the Id:"+id);
	}
	
	public String feedbackqueryByID(String id) throws SAXException, IOException, ParserConfigurationException, QueryLoadingException {		
		
		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < feedBackNodeList.getLength(); value++) {
			Element element = (Element) feedBackNodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				return element.getTextContent().trim();
		}
		throw new QueryLoadingException("Feedback Query not found for the Id:"+id);

	}
}

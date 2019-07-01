<%@page import="com.oop.model.WebCam"%>
<%@page import="com.oop.model.DvdWriter"%>
<%@page import="com.oop.model.Ups"%>
<%@page import="com.oop.model.Printer"%>
<%@page import="com.oop.model.Ram"%>
<%@page import="com.oop.model.HardDiskDrive"%>
<%@page import="com.oop.model.Monitor"%>
<%@page import="com.oop.model.SparePart"%>
<%@page import="com.oop.model.SparePartCategory"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="java.util.*"%>
<%@page import="com.sun.prism.Image"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
	<link rel="stylesheet" type="text/css" href="stylesheets/pageTopicStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/searchResultsStyleSheet.css">
</head>
<body class="searchResultsBody">
			<div style = "text-align: center;">
				<h2 class ="pageTopic">Search Results</h2>
				
				<% int counter = 0;%> 
				<c:forEach items="${resultsList}" >
					<%counter=counter+1; %>
				 </c:forEach>
				 <p><%=counter+" results found." %></p>
				 
			</div>
			
			<div align="center">	
			
			<%if (counter!=0){ %>
			----------------------------------------
			<% }%>	
			
				<table>
				  <c:forEach items="${resultsList}" var="item">
					  	
					  	<tr>
					    	<td>Type: </td>
					    	<td>< c:out value="${item.type}" /></td>
					    </tr>
		 			  	<tr>
					    	<td>Type: </td>
					    	<td>< c:out value="${item.designation}" /></td>
					    </tr>
		 			
					    <tr>
					    	<td>Manufacture: </td>
					    	<td><c:out value="${item.manufacture}" /></td>
					    </tr>
					    <tr>
					    	<td>Description: </td>
					    	<td><c:out value="${item.description}" /></td>
					    </tr>
					    <tr>
					    	<td>Model No: </td>
					    	<td><c:out value="${item.modelNo}" /></td>
					    </tr>
					     <tr>
					    	<td>Available Count: </td>
					    	<td><c:out value="${item.availableCount}" /></td>
					    </tr>
					    
					  	<tr>
					  	  <td>Price: </td>
					      <td><c:out value="${item.price}" /></td>
					    </tr>
					    
					    
					    
					    
					   <c:set var="HDD" value="<%=SparePartCategory.HDD%>" />
						<c:if test="${item.type==HDD}">
						<tr>
							<td>RPM: </td>
					      	<td><c:out value="${item.rpm}" /></td>
					    </tr>
					    <tr>
							<td>hddCapacity: </td>
					      	<td><c:out value="${item.capacity}" /></td>
					    </tr>
					    </c:if>
					    
				       
				       
				
					   <c:set var="MONITOR" value="<%=SparePartCategory.MONITOR%>" />
						<c:if test="${item.type==MONITOR}">
						<tr>
							<td>Screen Size: </td>
					      	<td><c:out value="${item.screenSize}" /></td>
					    </tr>
					    <tr>
							<td>Technology: </td>
					      	<td><c:out value="${item.technology}" /></td>
					    </tr>
					    </c:if>       
				    
				    
				    
				    
				    
				       <c:set var="RAM" value="<%=SparePartCategory.RAM%>" />
						<c:if test="${item.type==RAM}">
						<tr>
							<td> RAM Capacity: </td>
					      	<td><c:out value="${item.capacity}" /></td>
					    </tr>
					    <tr>
							<td>RAM Type: </td>
					      	<td><c:out value="${item.ramType}" /></td>
					    </tr>
					    </c:if>   
					    
					    
					    
					    
			     		<c:set var="PRINTER" value="<%=SparePartCategory.PRINTER%>" />
						<c:if test="${item.type==PRINTER}">
						<tr>
							<td>Printer type: </td>
					      	<td><c:out value="${item.printerType}" /></td>
					    </tr>
					    <tr>
							<td>Sheet Size : </td>
					      	<td><c:out value="${item.sheetSize}" /></td>
					    </tr>
					    </c:if>   
					    
				  	
	
			    		<c:set var="UPS" value="<%=SparePartCategory.UPS%>" />
						<c:if test="${item.type==UPS}">
						<tr>
							<td>Voltage: </td>
					      	<td><c:out value="${item.voltage}" /></td>
					    </tr>
					    <tr>
							<td>Amp-Hour : </td>
					      	<td><c:out value="${item.ampHour}" /></td>
					    </tr>
					    <tr>
							<td>Runtime : </td>
					      	<td><c:out value="${item.runTime}" /></td>
					    </tr>
					    </c:if> 
			    
			    
			    
			    
			    	<c:set var="DVD_WRITER" value="<%=SparePartCategory.DVDWRITER%>" />
						<c:if test="${item.type==DVD_WRITER}">
						<tr>
							<td>DVD Writer Speed: </td>
					      	<td><c:out value="${item.dvdWriterSpeed}" /></td>
					    </tr>
					    <tr>
							<td>DVD Writer type : </td>
					      	<td><c:out value="${item.dvdWriterType}" /></td>
					    </tr>
					    </c:if> 
	
	
	
	
						<c:set var="WEBCAM" value="<%=SparePartCategory.WEBCAM%>" />
						<c:if test="${item.type==WEBCAM}">
						<tr>
							<td>MegaPixel : </td>
					      	<td><c:out value="${item.megaPixel}" /></td>
					    </tr>
					    </c:if>
		
			     
			    
					    <tr>
					      	<td>
						      	<FORM METHOD="POST" action = "updateSparePart.jsp">
						      		<input type="hidden" name="sparePartType" value="${item.type}" /> 
						      		<input type="hidden" name="sparePartId" value="${item.id}" /> 
						      		<input type="hidden" name="sparePartPrice" value="${item.price}" />
						      		<input type="hidden" name="sparePartAvailableCount" value="${item.availableCount}" />
						      		<input type="hidden" name="sparePartDescription" value="${item.description}" />
						      		<input type="hidden" name="sparePartManufacture" value="${item.manufacture}" /> 
		        					<input type="hidden" name="sparePartModelNo" value="${item.modelNo}" /> 
		        					<input type="hidden" name="employeeDesignation" value="${item.designation}" /> 
		        					<c:if test="${item.type==MONITOR}">
			        					<input type="hidden" name="MonitorScreenSize" value="${item.screenSize}" /> 
			        					<input type="hidden" name="MonitorTechnology" value="${item.technology}" /> 
		        					</c:if>
		        					<c:if test="${item.type==HDD}">
			        					<input type="hidden" name="HDDCapacity" 	 value="${item.capacity}" /> 
			        					<input type="hidden" name="HDDRpm" 			value="${item.rpm}" />
		        					</c:if>
		        					<c:if test="${item.type==RAM}">
			        					<input type="hidden" name="RamCapacity"		 value="${item.capacity}" />
			        					<input type="hidden" name="RamType"		 	value="${item.ramType}" />
		        					</c:if>
		        					<c:if test="${item.type==PRINTER}">
			        					<input type="hidden" name="PrinterType"		 value="${item.printerType}" />
			        					<input type="hidden" name="SheetSize"		 value="${item.sheetSize}" />
		        					</c:if>
		        					<c:if test="${item.type==UPS}">
			        					<input type="hidden" name="Voltage"		 	value="${item.voltage}" />
			        					<input type="hidden" name="ampHour"		 	value="${item.ampHour}" />
			        					<input type="hidden" name="runTime"		 	value="${item.runTime}" />
		        					</c:if>
		        					<c:if test="${item.type==DVD_WRITER}">
			        					<input type="hidden" name="dvdWriterSpeed" value="${item.dvdWriterSpeed}" />
			        					<input type="hidden" name="dvdWriterType" 	value="${item.dvdWriterType}" />
		        					</c:if>
		        					<c:if test="${item.type==WEBCAM}">
		        						<input type="hidden" name="megaPixel"		value="${item.megaPixel}" />
		        					</c:if>
		        					<INPUT TYPE="submit" VALUE="Edit" class="searchResults-button">
		    					</FORM>
					      	
					      	</td>
					      	
					      	<td>
						      	<FORM action="deleteSparePart" METHOD="POST">
						      		<input type="hidden" name="sparePartIdForDelete" value="${item.id}" />
		        					<input type="submit" VALUE="Delete" class="searchResults-button"/>
		    					</FORM>
					      	</td>
					    </tr>
					    
					    <tr>
	    					<td colspan="2">
	    					----------------------------------------
	    					</td>
	  					</tr>
					    
				  </c:forEach>
				</table> 
			
			</div>
				 
			<br><br><br>	 
			<div style="text-align: center;">
				 <a href="search.jsp" style="text-decoration: none">Back to Search</a>
			</div>

  
</body>
</html>
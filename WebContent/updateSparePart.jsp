<%@page import="com.oop.model.WebCam"%>
<%@page import="com.oop.model.DvdWriter"%>
<%@page import="com.oop.model.Ups"%>
<%@page import="com.oop.model.Printer"%>
<%@page import="com.oop.model.Ram"%>
<%@page import="com.oop.model.HardDiskDrive"%>
<%@page import="com.oop.model.Monitor"%>
<%@page import="com.oop.model.SparePart"%>
<%@page import="com.oop.model.SparePartCategory"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>update Spare Part</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<script>
		$(document).ready(function() {
			$("select").change(function() {
				$(this).find("option:selected").each(function() {
					if ($(this).attr("value") == "monitor") {
						$(".box").not(".common_details").hide();
						$(".common_details").show();
						$(".box").not(".common_details").val("");
						
						$(".box1").not(".monitor_details").hide();
						$(".monitor_details").show();
						$(".box1").not(".monitor_details").val("");
					} 

					else if ($(this).attr("value") == "hdd") {
						$(".box").not(".common_details").hide();
						$(".common_details").show();
						$(".box").not(".common_details").val("");
						
						$(".box1").not(".hdd_details").hide();
						$(".hdd_details").show();
						$(".box1").not(".hdd_details").val("");
					}
					
					else if ($(this).attr("value") == "ram") {
						$(".box").not(".common_details").hide();
						$(".common_details").show();
						$(".box").not(".common_details").val("");
						
						$(".box1").not(".ram_details").hide();
						$(".ram_details").show();
						$(".box1").not(".ram_details").val("");
					}
					
					else if ($(this).attr("value") == "printer") {
						$(".box").not(".common_details").hide();
						$(".common_details").show();
						$(".box").not(".common_details").val("");
						
						$(".box1").not(".printer_details").hide();
						$(".printer_details").show();
						$(".box1").not(".printer_details").val("");
					}
					else if ($(this).attr("value") == "ups") {
						$(".box").not(".common_details").hide();
						$(".common_details").show();
						$(".box").not(".common_details").val("");
						
						$(".box1").not(".ups_details").hide();
						$(".ups_details").show();
						$(".box1").not(".ups_details").val("");
					}
					else if ($(this).attr("value") == "dvdWriter") {
						$(".box").not(".common_details").hide();
						$(".common_details").show();
						$(".box").not(".common_details").val("");
						
						$(".box1").not(".dvdwriter_details").hide();
						$(".dvdwriter_details").show();
						$(".box1").not(".dvdwriter_details").val("");
					}
					else if ($(this).attr("value") == "webCam") {
						$(".box").not(".common_details").hide();
						$(".common_details").show();
						$(".box").not(".common_details").val("");
						
						$(".box1").not(".webcam_details").hide();
						$(".webcam_details").show();
						$(".box1").not(".webcam_details").val("");
					}
					

					else {
						$(".box").hide();
					}
				});
			}).change();
		});
		</script>
		
		
		<script type = "text/javascript">
		   
		      // Form validation code
		      function validate(price,count) {
		      	//price validation
		         if( document.sparePartUpdateForm.price.value == "" ) {
		            alert( "Please Enter price" );
		            document.sparePartUpdateForm.price.focus() ;
		            return false;
		         }
		      	
		      	
		      	//count validation
		         if( document.sparePartUpdateForm.count.value == "" ) {
		            alert( "Please enter number of items to added." );
		            document.sparePartUpdateForm.count.focus() ;
		            return false;
		         }
		      	
		         //model no validation
		         if( document.sparePartUpdateForm.modelNo.value == "" ) {
			            alert( "Please enter model number." );
			            document.sparePartUpdateForm.modelNo.focus() ;
			            return false;
			         }
		         
		         //manufacture validation
		         if( document.sparePartUpdateForm.manufacture.value == "" ) {
			            alert( "Please manufacture name." );
			            document.sparePartUpdateForm.manufacture.focus() ;
			            return false;
			         }
		         
		         //Description validation
		         if( document.sparePartUpdateForm.description.value == "" ) {
			            alert( "Please enter description about the item." );
			            document.sparePartUpdateForm.description.focus() ;
			            return false;
			         }
		         
		         //designation validation
		         if( document.sparePartUpdateForm.designation.value == "" ) {
			            alert( "Please enter your designation." );
			            document.sparePartUpdateForm.designation.focus() ;
			            return false;
			         }
		         
		         var valprice = /^\d+(\.\d{0,2})?$/;
					if(! price.value.match(valprice))
					{
						alert("Please enter price as float number");
						document.getElementById("price").value="";
						document.sparePartUpdateForm.price.focus() ;
			            return false;
					}
			         
					var valcount = /^[0-9]+$/;
					if(! count.value.match(valcount))
					{
						alert("Please enter count as integer number");
						document.getElementById("count").value="";
						document.sparePartUpdateForm.count.focus() ;
			            return false;
					}
		         
		         return( true );
		      }
		   
	</script>

		<link rel="stylesheet" type="text/css" href="stylesheets/updateItemsStyleSheet.css">
		<link rel="stylesheet" type="text/css" href="stylesheets/pageTopicStyleSheet.css">
		<link rel="stylesheet" type="text/css" href="stylesheets/formStyleSheet.css">

	</head>
	
	<body class ="updateItemsBody">
	
	<h2 class ="pageTopic" style="color: black; ">Update Spare Part Details</h2><br>

			<form method="POST" action="updateSparePart" name = "sparePartUpdateForm" onsubmit = "return(validate(price,count));">
			 <fieldset class="centerForm" style=" border:4px groove; border-radius: 10px;width:350px"> 
				<table>
				<col width="150">
					<tr>
						<td style="font-weight: bold; font-size: 16px;">Spare part category :</td>
						<td style="font-weight: bold; font-size: 16px;">
						
							<%= request.getParameter("sparePartType") %>
						
						</td>
					</tr>
				</table>
			
				<div class="common_details box">			
				
					<input type="hidden" name="sparePartId" value="<%=request.getParameter("sparePartId").trim() %>" />
					<input type="hidden" name="sparePartType" value="<%=request.getParameter("sparePartType").trim() %>" /><br> 
				
				 <table>
					  <tr>
						<td>Price </td>
						<td><input type="text" name="price" id="price" value="<%=Float.parseFloat(request.getParameter("sparePartPrice").trim()) %>"/></td>
					  </tr>
					  <tr>
						<td>Count</td>
						<td><input type="text" name="count" id="count" value="<%=Integer.parseInt(request.getParameter("sparePartAvailableCount").trim()) %>"/></td>
					  </tr>
					  <tr>
						<td>Model No.</td>
						<td><input type="text" name="modelNo" value="<%=request.getParameter("sparePartModelNo").trim() %>" /></td>
					  </tr>
					   <tr>
						<td>Manufacture</td>
						<td><input type="text" name="manufacture"   value="<%=request.getParameter("sparePartManufacture").trim() %>"/></td>
					  </tr>
					  <tr>
						<td>Description</td>
						<td><input type="text" name="description"   value="<%=request.getParameter("sparePartDescription") %>" /></td>
					  </tr>
					  <tr>
						<td>Employee Designation</td>
						<td><input type="text" name="designation"  value="<%=request.getParameter("employeeDesignation").trim() %>" /></td>
					  </tr>
				</table> 
				
				</div>
				
				<div class="monitor_details box1">		
						
				<!--only for monitor -start-->
				<table>
				<col width="150">
				<c:set var="MONITOR" value="<%=SparePartCategory.MONITOR%>" />
				<c:if test="${item.type==MONITOR}">
					<tr>
						<td>Screen Size	</td>
						<td><input type="text" name="screenSize" onkeyup="checkDec(this);"  value="<%=request.getParameter("screenSize").trim() %>" /></td>
					</tr>
					<tr>
						<td>Technology</td>
						<td><input type="text" name="technology"  value="<%=request.getParameter("technology").trim() %>" /></td>
					</tr>
				</c:if>
				</table>
				<!--only for monitor -end-->			
				</div>
						
				<div class="hdd_details box1">
				<!--only for HDD -start-->
				<table>
				<col width="150">
				<c:set var="HDD" value="<%=SparePartCategory.HDD%>" />
				<c:if test="${item.type==HDD}">
					<tr>
						<td>HDD Capacity</td>
						<td><input type="text" name="hddCapacity"  value="<%=request.getParameter("capacity").trim() %>" /></td>
					</tr>
					<tr>
						<td>RPM speed</td>
						<td><input type="text" name="rpm"  value="<%=request.getParameter("rpm").trim() %>" /></td>
					</tr>
				</c:if>
				</table>			 
				<!--only for HDD -end-->
				</div>
				
				<div class="ram_details box1">
				<!--only for RAM -start-->
				<table>
				<col width="150">
				<c:set var="RAM" value="<%=SparePartCategory.RAM%>" />
				<c:if test="${item.type==RAM}">
					<tr>
						<td>RAM Capacity</td>
						<td><input type="text" name="ramCapacity"  value="<%=request.getParameter("capacity").trim() %>" /></td>
					</tr>
					<tr>
						<td>RAM type</td>
						<td><input type="text" name="ramType"  value="<%=request.getParameter("ramType").trim() %>" /></td>
					</tr>
				</c:if>
				</table>
				<!--only for RAM -end-->
				</div>
				
				<div class="printer_details box1">			
				<!--only for Printer -start-->
				<table>
				<col width="150">
				<c:set var="PRINTER" value="<%=SparePartCategory.PRINTER%>" />
				<c:if test="${item.type==PRINTER}">
					<tr>
						<td>Printer Type</td>
						<td> <input type="text" name="printerType" value="<%=request.getParameter("printerType").trim() %>" /></td>
					</tr>
					<tr>
						<td>Sheet Size</td>
						<td><input type="text" name="sheetSize" value="<%=request.getParameter("sheetSize").trim() %>" /></td>
					</tr>
				</c:if>
				</table>
				<!--only for Printer -end-->
				</div>
				
				<div class="ups_details box1">
				<!--only for UPS -start-->
				<table>
				<col width="150">
				<c:set var="UPS" value="<%=SparePartCategory.UPS%>" />
				<c:if test="${item.type==UPS}">
					<tr>
						<td>Voltage	</td>
						<td><input type="text" name="voltage" value="<%=request.getParameter("voltage").trim() %>" /></td>
					</tr>
					<tr>
						<td>AmpHours</td>
						<td><input type="text" name="ampHours"  value="<%=request.getParameter("ampHour").trim() %>" /></td>
					</tr>
					<tr>
						<td>Run Time</td>
						<td><input type="text" name="runTime"  value="<%=request.getParameter("runTime").trim() %>" /></td>
					</tr>
				</c:if>
				</table>
				<!--only for UPS -end -->
				</div>	
	
				<div class="dvdwriter_details box1">
				<!--only for DVD Writer -start-->
				<table>
				<col width="150">
				<c:set var="DVD_WRITER" value="<%=SparePartCategory.DVDWRITER%>" />
				<c:if test="${item.type==DVD_WRITER}">
					<tr>
						<td>Speed</td>
						<td><input type="text" name="dvdWriterSpeed"  value="<%=request.getParameter("dvdWriterSpeed").trim() %>" /></td>
					</tr>
					<tr>
						<td>DVD Writer Type</td>
						<td><input type="text" name="dvdWriterType"  value="<%=request.getParameter("dvdWriterType").trim() %>" /></td>
					</tr>
				</c:if>
				</table>		
				<!--only for DVD Writer -end-->
				</div>
				
				<div class="webcam_details box1">
				<!--only for WebCam -start-->
				<table>
				<c:set var="WEBCAM" value="<%=SparePartCategory.WEBCAM%>" />
				<c:if test="${item.type==WEBCAM}">
				<col width="150">
					<tr>
						<td>MegaPixel</td>
						<td><input type="text" name="megaPixel" value="<%=request.getParameter("megaPixel").trim() %>" /></td>
					</tr>
				</c:if>
				</table>
				<!--only for WebCam -end-->	
				</div>
					 
				<br>
					 
				 <div style=" text-align: center;">
					<input type="submit" value="Update Spare Part" class="update-button" style=" text-align: center;"/><br><br>	
					<input type="reset" value="Reset" class="update-button" /><br><br>
				 </div> 
			
				<div style="text-align: center;">
					 <a href="index.jsp" style="text-decoration: none">Back to Home</a>
				</div>
					
				 </fieldset>	
			</form>
			
	</body>
</html>
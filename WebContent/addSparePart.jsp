<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Add Spare Part</title>
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
		         if( document.sparePartAddeForm.price.value == "" ) {
		            alert( "Please Enter price" );
		            document.sparePartAddeForm.price.focus() ;
		            return false;
		         }
		      	
		      	
		      	//count validation
		         if( document.sparePartAddeForm.count.value == "" ) {
		            alert( "Please enter number of items to added." );
		            document.sparePartAddeForm.count.focus() ;
		            return false;
		         }
		      	
		         //model no validation
		         if( document.sparePartAddeForm.modelNo.value == "" ) {
			            alert( "Please enter model number." );
			            document.sparePartAddeForm.modelNo.focus() ;
			            return false;
			         }
		         
		         //manufacture validation
		         if( document.sparePartAddeForm.manufacture.value == "" ) {
			            alert( "Please manufacture name." );
			            document.sparePartAddeForm.manufacture.focus() ;
			            return false;
			         }
		         
		         //Description validation
		         if( document.sparePartAddeForm.description.value == "" ) {
			            alert( "Please enter description about the item." );
			            document.sparePartAddeForm.description.focus() ;
			            return false;
			         }
		         
		         //designation validation
		         if( document.sparePartAddeForm.designation.value == "" ) {
			            alert( "Please enter your designation." );
			            document.sparePartAddeForm.designation.focus() ;
			            return false;
			         }
		         

				var valprice = /^\d+(\.\d{0,2})?$/;
				if(! price.value.match(valprice))
				{
					alert("Please enter price as float number");
					document.getElementById("price").value="";
					document.sparePartAddeForm.price.focus() ;
		            return false;
				}
		         
				var valcount = /^[0-9]+$/;
				if(! count.value.match(valcount))
				{
					alert("Please enter count as integer number");
					document.getElementById("count").value="";
					document.sparePartAddeForm.count.focus() ;
		            return false;
				}
				
		         return( true );
		      }
		   
		</script>
		
	
	<link rel="stylesheet" type="text/css" href="stylesheets/addSparePartStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/formButtonStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/pageTopicStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/formStyleSheet.css">

	</head>
	
	<body class="addSparePartBody">
	
		<h2 class ="pageTopic">Add Computer Spare Parts</h2>
	
		<form method="POST" action="addSparePart" name = "sparePartAddeForm" onsubmit = "return(validate(price,count));">
		<fieldset class="centerForm" style=" border:4px groove; border-radius: 10px;width:350px"> 
			
				<br>
				
				<table class="centerTable">
				<col width="150">
					<tr>
						<td>Spare part category</td>
						<td>
						
							<select name="sparePartType" style="width:143px;">
								<option value="monitor">Monitor</option>
								<option value="hdd">Hard Disk Drive</option>
								<option value="ram">RAM</option>
								<option value="printer">Printer</option>
								<option value="ups">UPS</option>
								<option value="dvdWriter">DVD Writer</option>
								<option value="webCam">WebCam</option>
							</select>
						
						</td>
					</tr>
				</table>
			
				<div class="common_details box">			
	
				 <table class="centerTable">
					  <tr>
						<td>Price </td>
						<td><input type="text" name="price" id="price"/></td>
					  </tr>
					  <tr>
						<td>Count</td>
						<td><input type="text" name="count"  id="count"/></td>
					  </tr>
					  <tr>
						<td>Model No.</td>
						<td><input type="text" name="modelNo" /></td>
					  </tr>
					   <tr>
						<td>Manufacture</td>
						<td><input type="text" name="manufacture" /></td>
					  </tr>
					  <tr>
						<td>Description</td>
						<td><input type="text" name="description" /></td>
					  </tr>
					  <tr>
						<td>Employee Designation</td>
						<td><input type="text" name="designation" /></td>
					  </tr>
				</table> 
				
				</div>
				
				<div class="monitor_details box1">
				
				<!--only for monitor -start-->
				<table class="centerTable">
				<col width="150">
					<tr>
						<td>Screen Size	</td>
						<td><input type="text" name="screenSize" /></td>
					</tr>
					<tr>
						<td>Technology</td>
						<td><input type="text" name="technology" /></td>
					</tr>
				</table>
				<!--only for monitor -end-->			
				</div>
						
				<div class="hdd_details box1">
				<!--only for HDD -start-->
				<table class="centerTable">
				<col width="150">
					<tr>
						<td>HDD Capacity</td>
						<td><input type="text" name="hddCapacity" /></td>
					</tr>
					<tr>
						<td>RPM speed</td>
						<td><input type="text" name="rpm" /></td>
					</tr>
				</table>			 
				<!--only for HDD -end-->
				</div>
				
				<div class="ram_details box1">
				<!--only for RAM -start-->
				<table class="centerTable">
				<col width="150">
					<tr>
						<td>RAM Capacity</td>
						<td><input type="text" name="ramCapacity" /></td>
					</tr>
					<tr>
						<td>RAM type</td>
						<td><input type="text" name="ramType" /></td>
					</tr>
				</table>
				<!--only for RAM -end-->
				</div>
				
				<div class="printer_details box1">			
				<!--only for Printer -start-->
				<table class="centerTable">
				<col width="150">
					<tr>
						<td>Printer Type</td>
						<td> <input type="text" name="printerType" /></td>
					</tr>
					<tr>
						<td>Sheet Size</td>
						<td><input type="text" name="sheetSize" /></td>
					</tr>
				</table>
				<!--only for Printer -end-->
				</div>
				
				<div class="ups_details box1">
				<!--only for UPS -start-->
				<table class="centerTable">
				<col width="150">
					<tr>
						<td>Voltage	</td>
						<td><input type="text" name="voltage" /></td>
					</tr>
					<tr>
						<td>AmpHours</td>
						<td><input type="text" name="ampHours" /></td>
					</tr>
					<tr>
						<td>Run Time</td>
						<td><input type="text" name="runTime" /></td>
					</tr>
				</table>
				<!--only for UPS -end -->
				</div>	
	
				<div class="dvdwriter_details box1">
				<!--only for DVD Writer -start-->
				<table class="centerTable">
				<col width="150">
					<tr>
						<td>Speed</td>
						<td><input type="text" name="dvdWriterSpeed" /></td>
					</tr>
					<tr>
						<td>DVD Writer Type</td>
						<td><input type="text" name="dvdWriterType" /></td>
					</tr>
				</table>		
				<!--only for DVD Writer -end-->
				</div>
				
				<div class="webcam_details box1">
				<!--only for WebCam -start-->
				<table class="centerTable">
				<col width="150">
					<tr>
						<td>MegaPixel</td>
						<td><input type="text" name="megaPixel" /></td>
					</tr>
				</table>
				<!--only for WebCam -end-->	
				</div>
				<br>

			<div align="center">			
				<input type="submit" value="Add Spare Part" class="add-button" /> 	<br><br>	
				<input type="reset" value="Reset" class="reset-button" /><br><br>
			</div>
			
			<div style="text-align: center;">
				 <a href="index.jsp" style="text-decoration: none">Back to Home</a>
			</div>
			
		</fieldset>		
		</form>
	</body>
</html>
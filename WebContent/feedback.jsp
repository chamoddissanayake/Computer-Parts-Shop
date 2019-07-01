<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Feedback</title>
	<link rel="stylesheet" type="text/css" href="stylesheets/pageTopicStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/feedbackStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/feedbackButtonStyleSheet.css">
	
	<script type = "text/javascript">
		   
		      //Add Feedback Form validation code
		      function validate1() {
		      	//customerId validation
		         if( document.addFeedbackForm.customerId.value == "" ) { 
		            alert( "Please Enter Customer ID" );
		            document.addFeedbackForm.customerId.focus() ;
		            return false;
		         }
		       //feedbackTopic validation
		         if( document.addFeedbackForm.feedbackTopic.value == "" ) {
		            alert( "Please Enter Feedback Topic" );
		            document.addFeedbackForm.feedbackTopic.focus() ;
		            return false;
		         }
		       //feedback Description validation
		         if( document.addFeedbackForm.feedbackDescription.value == "" ) {
		            alert( "Please Enter Feedback Description" );
		            document.addFeedbackForm.feedbackDescription.focus() ;
		            return false;
		         } 
		         return( true );
		      }
		   
		</script>
		
		<script type = "text/javascript">
		   
		      //Add Feedback Form validation code
		      function validate2(feedbackIdForDelete) {
		      	//FeedbackId validation
		         if( document.deleteFeedbackForm.feedbackIdForDelete.value == "" ) { 
		            alert( "Please Enter Feedback ID" );
		            document.deleteFeedbackForm.feedbackIdForDelete.focus() ;
		            return false;
		         }
		      	
		     	var fbId = /^[0-9]+$/;
				if(! feedbackIdForDelete.value.match(fbId))
				{
					alert("Please feedbackId as integer number");
					document.getElementById("feedbackIdForDelete").value="";
					document.deleteFeedbackForm.feedbackIdForDelete.focus() ;
		            return false;
				}
				
		         return( true );
		      }
		   
		</script>
	
		<script type = "text/javascript">
		   
		      //Add Feedback Form validation code
		      function validate3(feedbackIdForUpdate) {
		      	//feedbackId validation
		         if( document.editFeedbackForm.feedbackIdForUpdate.value == "" ) { 
		            alert( "Please Enter Feedback ID" );
		            document.editFeedbackForm.feedbackIdForUpdate.focus() ;
		            return false;
		         }
		      	
	         var fbId = /^[0-9]+$/;
				if(! feedbackIdForUpdate.value.match(fbId))
				{
					alert("Please feedbackId as integer number");
					document.getElementById("feedbackIdForUpdate").value="";
					document.editFeedbackForm.feedbackIdForUpdate.focus() ;
		            return false;
				}
		         return( true );
		      }
		   
		</script>	
	
	
	
</head>

<body class ="feedbackBody">

<h2 class ="pageTopic" style="color: white; ">Manage Feedback</h2><br>

<table  style="width:100%">
	<tr>
    	<td colspan="2" align="center">
    	<!-- Largest table first row start -->
    	
			<!-- Add feedback form start -->
				<form method="POST" name="addFeedbackForm" action="addFeedback"  onsubmit = "return(validate1());">
				
				<table style="color: white; ">
					 <tr>
					    <th colspan="2" style="font-size: 20px; ">Add Feedback</th>
					  </tr>
					  <tr>
						    <td> 	CustomerId    </td>
						    <td>   	<input type="text" name="customerId" />    </td>
					  </tr>
					  <tr>
						    <td>   	Topic    </td>
						    <td>   	<input type="text" name="feedbackTopic" />    </td>
					  </tr>
					  <tr>
						    <td>   	Feedback    </td>
						    <td>  	<input type="text" name="feedbackDescription" />   </td>
					  </tr>
					  <tr>
					    	<td colspan="2" style="text-align: center;">
								<input type="submit" value="Add My Feedback" class="feedback-button" />
							</td>
					  </tr>
					  <tr>
					    	<td colspan="2" style="text-align: center;">
								<input type="reset" value="Reset" class="feedback-button" />
							</td>
					  </tr>
				</table>
				
				</form>
			<!-- Add feedback form end -->
    		<br>
    	<!-- Largest table first row  end -->
    	</td>
  	</tr>
  	<tr>
    	<td align="center">
    	<!-- Largest table second row left column start -->
    	
		  	<!-- Delete feedback form start -->
				
				<form method="POST" name ="deleteFeedbackForm" action="deleteFeedback" onsubmit = "return(validate2(feedbackIdForDelete));">
				
					<table style="color: white; ">
						 <tr>
						    <th colspan="2" style="font-size: 20px; ">Delete Feedback</th>
						  </tr>
						  <tr>
							    <td> 	Feedback ID    </td>
							    <td>   	<input type="text" name="feedbackIdForDelete" id ="feedbackIdForDelete"/>    </td>
						  </tr>
						  <tr>
						    	<td colspan="2" style="text-align: center;">								
									<input type="submit" value="Delete Feedback" class="feedback-button" />
								</td>
						  </tr>
						  <tr>
						    	<td colspan="2" style="text-align: center;">
									<input type="reset" value="Reset" class="feedback-button" />
								</td>
						  </tr>
					</table>
				
				</form>
				
			<!-- Delete feedback form end -->
    	
    	
    	<!-- Largest table second row left column end -->
    	</td>
    	
    	<td align="center">
    	<!-- Largest table second row right column start -->
    	
    	
		<!-- Edit feedback form start -->
	
	
			<form method="POST" name ="editFeedbackForm" action="searchFeedback" onsubmit = "return(validate3(feedbackIdForUpdate));">
			
					<table style="color: white; ">
					 <tr>
					    <th colspan="2" style="font-size: 20px; ">Update Feedback</th>
					  </tr>
					  <tr>
						    <td> 	Feedback ID    </td>
						    <td>   	<input type="text" name="feedbackIdForUpdate" id="feedbackIdForUpdate" />    </td>
					  </tr>
					  <tr>
					    	<td colspan="2" style="text-align: center;">								
								<input type="submit" value="Retrieve details" class="feedback-button" />
							</td>
					  </tr>
					  <tr>
					    	<td colspan="2" style="text-align: center;">
								<input type="reset" value="Reset" class="feedback-button" />
							</td>
					  </tr>
				</table>
			
			</form>
			
		<!-- Edit feedback form end -->
    	
    	
    	<!-- Largest table second row right column end -->
    	</td>
  	</tr>
</table> 

	
	<br><br><br><br><br>	
	<div>
		 <a href="index.jsp" style="text-decoration: none; color: white">Back to Home</a>
	</div>
		

</body>
</html>
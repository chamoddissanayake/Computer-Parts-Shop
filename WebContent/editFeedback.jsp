<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Edit Feedback</title>

	<link rel="stylesheet" type="text/css" href="stylesheets/editFeedbackStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/pageTopicStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/formStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/feedbackButtonStyleSheet.css">
	
</head>

<body class="editFeedbackBody">

		<h2 class ="pageTopic">Edit your feedback</h2>

	
			<form method="POST" action="editFeedback">
			<fieldset class="centerForm" style=" border:4px groove; border-radius: 10px;width:250px"> 

				<table style="color: black; ">
					 <tr>
					    <th colspan="2" style="font-size: 20px; " height="60">Edit Feedback</th>
					  </tr>
					   <tr height="35">
						    <td> 	FeedbackId    </td>
						    <td>   	<input type="text" name="feedbackIdForUpdate" value="<%=request.getParameter("feedbackIdForUpdate") %>" readonly />    </td>
					  </tr>
					  <tr height="35">
						    <td> 	CustomerId    </td>
						    <td>   	<input type="text" name="customerId" value="${feedbackObj.customerId}" />    </td>
					  </tr>
					  <tr height="35">
						    <td>   	Topic    </td>
						    <td>   	<input type="text" name="feedbackTopic" value="${feedbackObj.feedbackTopic}" />    </td>
					  </tr>
					  <tr height="35">
						    <td>   	Feedback    </td>
						    <td>  	<input type="text" name="feedbackDescription" value="${feedbackObj.feedbackDescription}"/>   </td>
					  </tr>
					  <tr height="35">
					    	<td colspan="2" style="text-align: center;">
								<input type="submit" value="Update My Feedback" class="feedback-button" />
							</td>
					  </tr>
					  <tr height="35">
					    	<td colspan="2" style="text-align: center;">
								<input type="reset" value="Reset" class="feedback-button" />
							</td>
					  </tr>
				</table>
				
				
			<div style="text-align: center;">
				 <a href="index.jsp" style="text-decoration: none">Back to Home</a>
			</div>
				
			</fieldset>	
			</form>
			
</body>
</html>
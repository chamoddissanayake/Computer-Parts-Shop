<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Search</title>

	<link rel="stylesheet" type="text/css" href="stylesheets/pageTopicStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/searchStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/formButtonStyleSheet.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/formStyleSheet.css">
	
	<script>
	  if (!("autofocus" in document.createElement("input"))) {
	  	document.getElementById("searchKeyWord").focus();
	  }
	</script>
	
	
</head>

<body class="searchBody">

	<h2 class ="pageTopic">Search items</h2>
	
	<br><br><br><br><br>
	
	<!-- Search form start -->
		<form method="POST" action="search">
			<fieldset class="centerForm" style=" border:4px groove; border-radius: 10px;width:350px"> 
				<br><br>
				<div style="text-align: center;">
						
				<table class="centerTable">
				  <tr>
				    <td>
				    		<p style="font-size: 20px;">Keyword: </p> 
				    </td>
				    
				    <td>
			    		<input type="text" name="searchKeyWord" id="searchKeyWord" autofocus="autofocus"/>
				    </td>
				  </tr>
				</table> 
					
												
					
				</div>
				<br>
				<div style="text-align: center;">
					<input type="submit" value="Search" class="add-button" /> &ensp;&ensp;
					<input type="reset" value="Reset" class="reset-button" /><br><br>
				</div>
				
				<div style="text-align: center;">
				 <a href="index.jsp" style="text-decoration: none">Back to Home</a>
			</div>
			</fieldset>
		</form>
	<!-- Search form end -->

</body>
</html>
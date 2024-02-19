<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<link rel="stylesheet" href="css/adminlogin.min.css">
<link rel="stylesheet" href="css/table.min.css">
</head>
<body style="background-color: #C5DFF8;">

	<%@include file = "header.jsp" %>
	
	<br><br><br>
	
	<h3 style="color:red;text-align:center;"><%= exception %></h2>
	
	<br><br><br>
	
	<form _lpchecked="1" action = "index.jsp" method = "post">
		<div class="d-flex flex-row align-items-center justify-content-between">
		    <button style="margin: 0 auto;" class="btn btn-primary">Home</button>
		</div>
	</form>
	
	<br><br><br>
	
	<%@include file = "footer.jsp" %>


</body>
</html>
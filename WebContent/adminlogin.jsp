<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="myerrorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="css/adminlogin.min.css">
</head>
<body style="background-color: #C5DFF8">
	
	<%
		if(session.getAttribute("token") != null)
			response.sendRedirect("admintasks.jsp");	
	%>
	
	<%@include file = "header.jsp" %>
	
	<%
		String msg = (String) session.getAttribute("AdminMsg");
		if(msg != null){
	%>		
		<h3 style="color:red;text-align:center;"><%= msg %></h2>
	<%	
			session.removeAttribute("AdminMsg");	
		}
	%>
	
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-5">
	   			<div style="background-color: #7895CB;" class="card">
	     			<h2 class="card-title text-center" style="color: #EEEEEE;">MyPortfolio Admin Login</h2>
	      			<div style="color:"grey";" class="card-body py-md-4">
	       				<form _lpchecked="1" action = "AdminController" method = "post">
	          				<div class="form-group">
	             				<input type="text" class="form-control" name = "username" placeholder="Username">
	        				</div>
	                        <div class="form-group">
	     						<input type="password" class="form-control" name = "password" placeholder="Password">
	   						</div>
							<div class="d-flex flex-row align-items-center justify-content-between">
								<button class="btn"><a style="color: #000000;" href="index.jsp">Home</a></button>
							    <button class="btn">Login</button>
						    </div>
						</form>
	     			</div>
	  			</div>
			</div>
		</div>
	</div>
	
	<%@include file = "footer.jsp" %>
	
</body>
</html>
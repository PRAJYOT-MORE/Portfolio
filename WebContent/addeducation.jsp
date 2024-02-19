<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="myerrorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Education</title>
<link rel="stylesheet" href="css/adminlogin.min.css">
<link rel="stylesheet" href="css/table.min.css">
</head>
<body style="background-color: #C5DFF8">
	
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
	
	<br><br>
	
	<form style="text-align: left; display:inline; padding : 20px; padding-left: 130px;" action="showeducation.jsp" method="post">
        <button class="logout-button">Back</button>
    </form>
    
    <form style="text-align: right; display:inline; padding : 20px; padding-left: 890px;" action="MyController" method="post">
	    <input type="hidden" name="check" value="logout">
        <button class="logout-button" type="submit">Logout</button>
    </form>
    
    <br><br>
	
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-5">
	   			<div style="background-color: #7895CB;" class="card">
	     			<h2 class="card-title text-center" style="color: #EEEEEE;">Add new Education</h2>
	      			<div style="color:"grey";" class="card-body py-md-4">
	       				<form _lpchecked="1" action = "EducationController" method = "post">
	          				<div class="form-group">
	             				<input type="text" class="form-control" name = "year" placeholder="Year">
	        				</div>
	                        <div class="form-group">
	     						<input type="text" class="form-control" name = "level" placeholder="Level">
	   						</div>
	   						<div class="form-group">
	             				<input type="text" class="form-control" name = "description" placeholder="Description">
	        				</div>
	        				<div class="form-group">
	             				<input type="text" class="form-control" name = "score" placeholder="Score">
	        				</div>
							<div class="d-flex flex-row align-items-center justify-content-between">
								<input type="hidden" name = "operation" value = "add">
							    <button style="margin: 0 auto;" class="btn btn-primary">Add</button>
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
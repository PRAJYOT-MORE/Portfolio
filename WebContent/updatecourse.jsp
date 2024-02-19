<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.ReadDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pojo.CoursePojo" %>
<%@ page errorPage="myerrorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Course</title>
<link rel="stylesheet" href="css/adminlogin.min.css">
<link rel="stylesheet" href="css/admintasks.min.css">
<link rel="stylesheet" href="css/update.min.css">

</head>
<body style="background-color: #C5DFF8">
	
	<%
		if(session.getAttribute("token") == null)
			response.sendRedirect("adminlogin.jsp");
	%>
	
	<%@include file = "header.jsp" %>
	
	
	<h1 class="card-title text-center" style="color: #7895CB;">Update Courses</h1>
	
	
	<br><br>
	
	<form style="text-align: left; display:inline; padding : 20px; padding-left: 130px;" action="showcourse.jsp" method="post">
        <button class="logout-button">Back</button>
    </form>
    
	<form style="text-align: right; display:inline; padding : 20px; padding-left: 890px;" action="MyController" method="post">
	    <input type="hidden" name="check" value="logout">
        <button class="logout-button" type="submit">Logout</button>
    </form>
	
	<br><br>

	
    <div style="margin-bottom:20px;" class="container">
		<div class="row justify-content-center">
			<div class="col-md-5">
				<div style="background-color: #7895CB;" class="card">
					<h2 class="card-title text-center" style="color: #EEEEEE;">Update Name</h2>
					<div style="color:"grey";" class="card-body py-md-4">
						<form _lpchecked="1" action = "CourseController" method = "post">                
				            <div class="form-group">
								<input type="text" class="form-control" name = "name" placeholder="Name">
							</div>
							<input type="hidden" name = "operation" value = "update">
							<input type="hidden" name = "column" value = "name">
							<div class="d-flex flex-row align-items-center justify-content-between">
								<button style="margin: 0 auto;" class="btn button-container">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
    
    <div style="margin-bottom:20px;" class="container">
		<div class="row justify-content-center">
			<div class="col-md-5">
				<div style="background-color: #7895CB;" class="card">
					<h2 class="card-title text-center" style="color: #EEEEEE;">Update Description</h2>
					<div style="color:"grey";" class="card-body py-md-4">
						<form _lpchecked="1" action = "CourseController" method = "post">                
							<div class="form-group">
					            <input type="text" class="form-control" name = "description" placeholder="Description">
					        </div>
							<input type="hidden" name = "operation" value = "update">
							<input type="hidden" name = "column" value = "description">
							<div class="d-flex flex-row align-items-center justify-content-between">
								<button style="margin: 0 auto;" class="btn">Update</button>
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
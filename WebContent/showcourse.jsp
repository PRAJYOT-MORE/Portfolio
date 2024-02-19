<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.ReadDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pojo.CoursePojo" %>
<%@ page errorPage="myerrorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Courses</title>
<link rel="stylesheet" href="css/table.min.css">
</head>
<body style="background-color: #C5DFF8">
	
	<%
		if(session.getAttribute("token") == null)
			response.sendRedirect("adminlogin.jsp");
	%>
	
	<%@include file = "header.jsp" %>
	
	<%
		String msg = (String) session.getAttribute("CourseMsg");
		if(msg != null){
	%>		
		<h3 style="color:blue;text-align:center;"><%= msg %></h2>
	<%	
			session.removeAttribute("CourseMsg");	
		}
	%>
	
	
	<h1 class="card-title text-center" style="color: #7895CB;">Courses</h1>
	
	<form style="text-align: left; display:inline; padding : 20px; padding-left: 130px;" action="admintasks.jsp" method="post">
        <button class="logout-button">Back</button>
    </form>
    
    
    
	<form style="text-align: right; display:inline; padding : 20px; padding-left: 890px;" action="MyController" method="post">
	    <input type="hidden" name="check" value="logout">
        <button class="logout-button" type="submit">Logout</button>
    </form>
  
	<br><br><br>
	
	<table style="margin: 0 auto;" class="content-table">
  		<thead>
    		<tr>
      			<th>Id</th>
      			<th>Name</th>
      			<th>Description</th>
      			<th>Operation</th>
    		</tr>
  		</thead>
  		<tbody>
  			<%
  				ArrayList<CoursePojo> al = new ReadDaoImpl().readCourse();
  				for(CoursePojo c : al){
  			%>
  			
  			<tr>
      			<td><%= c.getId()%></td>
      			<td><%= c.getName()%></td>
      			<td><%= c.getDescription()%></td>
      			<td>
      				<form action = "CourseController" method = "post">
      					<input type = "hidden" name = "operation" value = "delete">
      					<input type = "hidden" name = "id" value = <%= c.getId()%>>
      					<button class = "btn" style="color:red;">Delete</button>
      				</form>
      				<br>
      				<form action = "SaveForUpdateController" method = "post">
      					<input type = "hidden" name = "domain" value = "course">
      					<input type = "hidden" name = "id" value = <%= c.getId() %>>
      					<button class = "btn" style="color:green;">Update</button>
      				</form>
      			</td>
      		</tr>
      		
      		<%
  				}
      		%>      		
  		</tbody>
	</table>
	
	<div style="text-align: center;">
		<form style="text-align:center; padding : 40px;" action="addcourse.jsp" method="post">
			<button class="btn" type="submit">Add</button>
	    </form>
	</div>
	
	
	<%@include file = "footer.jsp" %>
	
</body>
</html>
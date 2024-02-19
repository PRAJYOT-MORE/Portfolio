<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.ReadDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pojo.EducationPojo" %>
<%@ page errorPage="myerrorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Education</title>
<link rel="stylesheet" href="css/table.min.css">
</head>
<body style="background-color: #C5DFF8">
	
	<%
		if(session.getAttribute("token") == null)
			response.sendRedirect("adminlogin.jsp");
	%>
	
	<%@include file = "header.jsp" %>
	
	<%
		String msg = (String) session.getAttribute("EducationMsg");
		if(msg != null){
	%>		
		<h3 style="color:blue;text-align:center;"><%= msg %></h2>
	<%	
			session.removeAttribute("EducationMsg");	
		}
	%>
	
	
	<h1 class="card-title text-center" style="color: #7895CB;">Education</h1>
	
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
      			<th>Year</th>
      			<th>Level</th>
      			<th>Description</th>
      			<th>Score</th>
      			<th>Operation</th>
    		</tr>
  		</thead>
  		<tbody>
  			<%
  				ArrayList<EducationPojo> al = new ReadDaoImpl().readEducation();
  				for(EducationPojo e : al){
  			%>
  			
  			<tr>
      			<td><%= e.getYear()%></td>
      			<td><%= e.getLevel()%></td>
      			<td><%= e.getDescription()%></td>
      			<td><%= e.getScore()%></td>      			
      			<td>
      				<form action = "EducationController" method = "post">
      					<input type = "hidden" name = "operation" value = "delete">
      					<input type = "hidden" name = "year" value = <%= e.getYear()%>>
      					<button class = "btn" style="color:red;">Delete</button>
      				</form>
      				<br>
      				<form action = "SaveForUpdateController" method = "post">
      					<input type = "hidden" name = "domain" value = "education">
      					<input type = "hidden" name = "year" value = <%= e.getYear() %>>
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
		<form style="text-align:center; padding : 40px;" action="addeducation.jsp" method="post">
			<button class="btn" type="submit">Add</button>
	    </form>
	</div>
	
	
	<%@include file = "footer.jsp" %>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.ReadDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pojo.ProjectPojo" %>
<%@ page errorPage="myerrorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Projects</title>
<link rel="stylesheet" href="css/table.min.css">
</head>
<body style="background-color: #C5DFF8">
	
	<%
		if(session.getAttribute("token") == null)
			response.sendRedirect("adminlogin.jsp");
	%>
	
	<%@include file = "header.jsp" %>
	
	<%
		String msg = (String) session.getAttribute("ProjectMsg");
		if(msg != null){
	%>		
		<h3 style="color:blue;text-align:center;"><%= msg %></h2>
	<%	
			session.removeAttribute("ProjectMsg");	
		}
	%>
	
	
	<h1 class="card-title text-center" style="color: #7895CB;">Projects</h1>
	
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
      			<th>Filename</th>
      			<th>File</th>
      			<th>Operation</th>
    		</tr>
  		</thead>
  		<tbody>
  			<%
  				ArrayList<ProjectPojo> pp = new ReadDaoImpl().readProject();
  				for(ProjectPojo p : pp){
  			%>
  			
  			<tr>
      			<td><%= p.getId()%></td>
      			<td><%= p.getFilename()%></td>
      			<td><img style="width:300px;" src="images/project/<%= p.getFilename()%>"></td>
      			<td>
      				<form enctype = "multipart/form-data" action = "ProjectController" method = "post">
      					<input type = "hidden" name = "operation" value = "delete">
      					<input type = "hidden" name = "file" value = "<%= p.getFilename()%>">
      					<button class = "btn" style="color:red;text:white">Delete</button>
      				</form>
      			</td>
      		</tr>
      		
      		<%
  				}
      		%>      		
  		</tbody>
	</table>
	
	<div style="text-align: center;">
		<form style="text-align:center; padding : 40px;" action="addproject.jsp" method="post">
			<button class="btn" type="submit">Add</button>
	    </form>
	</div>
	
	<%@include file = "footer.jsp" %>
	
</body>
</html>
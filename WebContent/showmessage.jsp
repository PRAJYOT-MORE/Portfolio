<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.ReadDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pojo.MessagePojo" %>
<%@ page errorPage="myerrorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Messages</title>
<link rel="stylesheet" href="css/table.min.css">
</head>
<body style="background-color: #C5DFF8">
	
	<%
		if(session.getAttribute("token") == null)
			response.sendRedirect("adminlogin.jsp");
	%>
	
	<%@include file = "header.jsp" %>
	
	<%
		String msg = (String) session.getAttribute("MessageMsg");
		if(msg != null){
	%>		
		<h3 style="color:blue;text-align:center;"><%= msg %></h2>
	<%	
			session.removeAttribute("MessageMsg");	
		}
	%>
	
	
	<h1 class="card-title text-center" style="color: #7895CB;">Messages</h1>
	
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
      			<th>Name</th>
      			<th>Email</th>
      			<th>Message</th>
      			<th>Operation</th>
    		</tr>
  		</thead>
  		<tbody>
  			<%
  				ArrayList<MessagePojo> al = new ReadDaoImpl().readMessage();
  				for(MessagePojo m : al){
  			%>
  			
  			<tr>
      			<td><%= m.getName()%></td>
      			<td><%= m.getEmail()%></td>
      			<td><%= m.getDescription()%></td>
      			<td>
      				<form action = "MessageController" method = "post">
      					<input type = "hidden" name = "operation" value = "delete">
      					<input type = "hidden" name = "email" value = <%= m.getEmail() %>>
      					<button class = "btn" style="color:red;text:white">Delete</button>
      				</form>
      			</td>
      		</tr>
      		
      		<%
  				}
      		%>      		
  		</tbody>
	</table>
	
	<%@include file = "footer.jsp" %>
	
</body>
</html>
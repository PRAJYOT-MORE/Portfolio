<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="myerrorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Tasks</title>
<link rel="stylesheet" href="css/admintasks.min.css">
</head>
<body style="background-color: #C5DFF8">
	
	<%
		if(session.getAttribute("token") == null)
			response.sendRedirect("adminlogin.jsp");
	%>
	
	<%@include file = "header.jsp" %>
	
	<%
		String msg = (String) session.getAttribute("AdminMsg");
		if(msg != null){
	%>		
		<h3 style="color:blue;text-align:center;"><%= msg %></h2>
	<%	
			session.removeAttribute("AdminMsg");	
		}
	%>
	
	<h1 class="card-title text-center" style="color: #7895CB;">Admin Tasks</h1>
	
	<br><br>
	
	<form style="text-align: left; display:inline; padding : 20px; padding-left: 130px;" action="index.jsp" method="post">
        <button class="logout-button">Back</button>
    </form>
	
	<form style="text-align: right; display:inline; padding : 20px; padding-left: 890px;" action="MyController" method="post">
	    <input type="hidden" name="check" value="logout">
        <button class="logout-button" type="submit">Logout</button>
    </form>
  
	<br><br>
	
	<div class="button-container">
  		<button class="button"><a style="color: #EEEEEE" href = "showachievement.jsp">Achievements</a></button>
  		<button class="button"><a style="color: #EEEEEE" href = "showcourse.jsp">Courses</a></button>
	</div>
	<div class="button-container">
  		<button class="button"><a style="color: #EEEEEE" href = "showeducation.jsp">Education</a></button>
  		<button class="button"><a style="color: #EEEEEE" href = "showmessage.jsp">Messages</a></button>
	</div>
	<div class="button-container">
  		<button class="button"><a style="color: #EEEEEE" href = "showproject.jsp">Projects</a></button>
	</div>
	
	<%@include file = "footer.jsp" %>
	
</body>
</html>
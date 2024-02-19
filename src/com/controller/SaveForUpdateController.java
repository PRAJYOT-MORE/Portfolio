package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveForUpdateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String domain = request.getParameter("domain");
		HttpSession session = request.getSession();
		
		if(domain.equals("achievement")) {
			int id = Integer.parseInt(request.getParameter("id"));
			session.setAttribute("id", id);
			response.sendRedirect("updateachievement.jsp");
		}
		else if(domain.equals("education")) {
			int year = Integer.parseInt(request.getParameter("year"));
			session.setAttribute("year", year);
			response.sendRedirect("updateeducation.jsp");
		}
		else if(domain.equals("course")) {
			int id = Integer.parseInt(request.getParameter("id"));
			session.setAttribute("id", id);
			response.sendRedirect("updatecourse.jsp");
		}
		
	}

}

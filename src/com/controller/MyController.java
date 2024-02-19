package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.InsertDaoImpl;
import com.validation.MessageValidation;


public class MyController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		String check = request.getParameter("check");
		
		if(check.equals("message")) {
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			
			String result = new MessageValidation().isValid(name, email, description);
			if(result.startsWith("Invalid")) {
				session.setAttribute("IndexMsg", result);
				response.sendRedirect("index.jsp");
			}
			else {
				int row = new InsertDaoImpl().insertMessage(name, email, description);
				if(row == 1) {
					session.setAttribute("IndexMsg", "Message sent Successfully");
					response.sendRedirect("index.jsp");
				}
				else {
					session.setAttribute("IndexMsg", "Something went wrong!");
					response.sendRedirect("index.jsp");
				}
			}
		}
		else if(check.equals("logout")) {
			session.removeAttribute("token");
			session.setAttribute("AdminMsg", "Logged Out Successfully");
			response.sendRedirect("adminlogin.jsp");
		}
	}
}
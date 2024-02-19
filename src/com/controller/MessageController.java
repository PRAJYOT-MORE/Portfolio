package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteDaoImpl;
import com.dao.InsertDaoImpl;

public class MessageController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession();
		
		if(operation.equals("delete")) {
			String email = request.getParameter("email");
			int row = new DeleteDaoImpl().deleteMessage(email);
			if(row == 1) {
				session.setAttribute("MessageMsg", "Row deleted Successfully");
				response.sendRedirect("showmessage.jsp");
			}
			else {
				session.setAttribute("MessageMsg", "Something went wrong!");
				response.sendRedirect("showmessage.jsp");
			}
		}
	}
}

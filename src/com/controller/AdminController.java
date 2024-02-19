package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dao.GetConnection;

public class AdminController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Session s = GetConnection.getSession();
		String sql = "select * from admin where username = :username and password = :password";
		
		Query q = s.createNativeQuery(sql);
		q.setParameter("username", username);
		q.setParameter("password", password);
		List l = q.getResultList();
		
		if(l.size() == 0) {
			session.setAttribute("AdminMsg", "Invalid Credentials!");
			response.sendRedirect("adminlogin.jsp");
		}
		else {
			session.setAttribute("AdminMsg", "Logged In Successfully");
			session.setAttribute("token", username);
			response.sendRedirect("admintasks.jsp");
		}
		
	}

}

package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteDaoImpl;
import com.dao.InsertDaoImpl;
import com.dao.UpdateDaoImpl;


public class EducationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession();
		
		if(operation.equals("delete")) {
			int year = Integer.parseInt(request.getParameter("year"));
			int row = new DeleteDaoImpl().deleteEducation(year);
			if(row == 1) {
				session.setAttribute("EducationMsg", "Row deleted Successfully");
				response.sendRedirect("showeducation.jsp");
			}
			else {
				session.setAttribute("EducationMsg", "Something went wrong!");
				response.sendRedirect("showeducation.jsp");
			}
		}
		else if(operation.equals("update")) {
			String column = request.getParameter("column");
			int year = (int) session.getAttribute("year");
			if(column.equals("level")) {
				String level = request.getParameter("level");
				int row = new UpdateDaoImpl().updateEducationLevel(level, year);
				if(row == 1) {
					session.setAttribute("EducationMsg", "Row updated Successfully");
					session.removeAttribute("year");
					response.sendRedirect("showeducation.jsp");
				}
				else {
					session.setAttribute("EducationMsg", "Something went wrong!");
					response.sendRedirect("showeducation.jsp");
				}
			}
			else if(column.equals("description")) {
				String description = request.getParameter("description");
				int row = new UpdateDaoImpl().updateEducationDescription(description, year);
				if(row == 1) {
					session.setAttribute("EducationMsg", "Row updated Successfully");
					session.removeAttribute("year");
					response.sendRedirect("showeducation.jsp");
				}
				else {
					session.setAttribute("EducationMsg", "Something went wrong!");
					response.sendRedirect("showeducation.jsp");
				}
			}
			else if(column.equals("score")) {
				String score = request.getParameter("score");
				int row = new UpdateDaoImpl().updateEducationScore(score, year);
				if(row == 1) {
					session.setAttribute("EducationMsg", "Row updated Successfully");
					session.removeAttribute("year");
					response.sendRedirect("showeducation.jsp");
				}
				else {
					session.setAttribute("EducationMsg", "Something went wrong!");
					response.sendRedirect("showeducation.jsp");
				}
			}
		}
		else if(operation.equals("add")) {
			int year = Integer.parseInt(request.getParameter("year"));
			String level = request.getParameter("level");
			String description = request.getParameter("description");
			String score = request.getParameter("score");
			int row = new InsertDaoImpl().insertEducation(year, level, description, score);
			if(row == 1) {
				session.setAttribute("EducationMsg", "Row added Successfully");
				response.sendRedirect("showeducation.jsp");
			}
			else {
				session.setAttribute("EducationMsg", "Something went wrong!");
				response.sendRedirect("showeducation.jsp");
			}
		}
	}
}

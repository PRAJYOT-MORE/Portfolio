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


public class CourseController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession();
		
		if(operation.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int row = new DeleteDaoImpl().deleteCourse(id);
			if(row == 1) {
				session.setAttribute("CourseMsg", "Row deleted Successfully");
				response.sendRedirect("showcourse.jsp");
			}
			else {
				session.setAttribute("CourseMsg", "Something went wrong!");
				response.sendRedirect("showcourse.jsp");
			}
		}
		else if(operation.equals("update")) {
			String column = request.getParameter("column");
			int id = (int) session.getAttribute("id");
			if(column.equals("name")) {
				String name = request.getParameter("name");
				int row = new UpdateDaoImpl().updateCourseName(name, id);
				if(row == 1) {
					session.setAttribute("CourseMsg", "Row updated Successfully");
					session.removeAttribute("id");
					response.sendRedirect("showcourse.jsp");
				}
				else {
					session.setAttribute("CourseMsg", "Something went wrong!");
					response.sendRedirect("showcourse.jsp");
				}
			}
			else if(column.equals("description")) {
				String description = request.getParameter("description");
				int row = new UpdateDaoImpl().updateCourseDescription(description, id);
				if(row == 1) {
					session.setAttribute("CourseMsg", "Row updated Successfully");
					session.removeAttribute("id");
					response.sendRedirect("showcourse.jsp");
				}
				else {
					session.setAttribute("CourseMsg", "Something went wrong!");
					response.sendRedirect("showcourse.jsp");
				}
			}
		}
		else if(operation.equals("add")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			int row = new InsertDaoImpl().insertCourse(id, name, description);
			if(row == 1) {
				session.setAttribute("CourseMsg", "Row added Successfully");
				response.sendRedirect("showcourse.jsp");
			}
			else {
				session.setAttribute("CourseMsg", "Something went wrong!");
				response.sendRedirect("showcourse.jsp");
			}
		}
	}

}

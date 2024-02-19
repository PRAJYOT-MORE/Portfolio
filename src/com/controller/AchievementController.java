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


public class AchievementController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession();
		
		if(operation.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int row = new DeleteDaoImpl().deleteAchievement(id);
			if(row == 1) {
				session.setAttribute("AchievementMsg", "Row deleted Successfully");
				response.sendRedirect("showachievement.jsp");
			}
			else {
				session.setAttribute("AchievementMsg", "Something went wrong!");
				response.sendRedirect("showachievement.jsp");
			}
		}
		else if(operation.equals("update")) {
			String column = request.getParameter("column");
			int id = (int) session.getAttribute("id");
			if(column.equals("title")) {
				String title = request.getParameter("title");
				int row = new UpdateDaoImpl().updateAchievementTitle(title, id);
				if(row == 1) {
					session.setAttribute("AchievementMsg", "Row updated Successfully");
					session.removeAttribute("id");
					response.sendRedirect("showachievement.jsp");
				}
				else {
					session.setAttribute("AchievementMsg", "Something went wrong!");
					response.sendRedirect("showachievement.jsp");
				}
			}
			else if(column.equals("description")) {
				String description = request.getParameter("description");
				int row = new UpdateDaoImpl().updateAchievementDescription(description, id);
				if(row == 1) {
					session.setAttribute("AchievementMsg", "Row updated Successfully");
					session.removeAttribute("id");
					response.sendRedirect("showachievement.jsp");
				}
				else {
					session.setAttribute("AchievementMsg", "Something went wrong!");
					response.sendRedirect("showachievement.jsp");
				}
			}
			else if(column.equals("year")) {
				int year = Integer.parseInt(request.getParameter("year"));
				int row = new UpdateDaoImpl().updateAchievementYear(year, id);
				if(row == 1) {
					session.setAttribute("AchievementMsg", "Row updated Successfully");
					session.removeAttribute("id");
					response.sendRedirect("showachievement.jsp");
				}
				else {
					session.setAttribute("AchievementMsg", "Something went wrong!");
					response.sendRedirect("showachievement.jsp");
				}
			}
		}
		else if(operation.equals("add")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int year = Integer.parseInt(request.getParameter("year"));
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			int row = new InsertDaoImpl().insertAchievement(id, year, title, description);
			if(row == 1) {
				session.setAttribute("AchievementMsg", "Row added Successfully");
				response.sendRedirect("showachievement.jsp");
			}
			else {
				session.setAttribute("AchievementMsg", "Something went wrong!");
				response.sendRedirect("showachievement.jsp");
			}
		}
	}
}

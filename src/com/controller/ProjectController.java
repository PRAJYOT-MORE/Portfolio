package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.DeleteDaoImpl;
import com.dao.InsertDaoImpl;
import com.fileprocessing.FileUploadDelete;


@MultipartConfig
public class ProjectController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession();
		
		if(operation.equals("delete")) {
			String file = request.getParameter("file");
			int row = new DeleteDaoImpl().deleteProject(request, file);
			if(row == 1) {
				session.setAttribute("ProjectMsg", "Project deleted Successfully");
				response.sendRedirect("showproject.jsp");
			}
			else {
				session.setAttribute("ProjectMsg", "Something went wrong!");
				response.sendRedirect("showproject.jsp");
			}
		}
		else if(operation.equals("add")) {
			Part part = request.getPart("filename");
			String filename = part.getSubmittedFileName();
			String UniqueFileName = format(filename);
			
			int id = Integer.parseInt(request.getParameter("id"));
			int row = new InsertDaoImpl().insertProject(id, UniqueFileName, request);
			if(row == 1) {
				session.setAttribute("ProjectMsg", "Project added Successfully");
				response.sendRedirect("showproject.jsp");
			}
			else {
				session.setAttribute("ProjectMsg", "Something went wrong!");
				response.sendRedirect("showproject.jsp");
			}
		}
	
	}
	
	private String format(String str) {
		String format = LocalDateTime.now().toString();
		String[] split = format.split(":");
		String unique = split[0] + split[1] + split[2] + str;
		return unique;
	}

}




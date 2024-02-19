package com.dao;

import javax.servlet.http.HttpServletRequest;

public interface DeleteDao {
	
	public int deleteCourse(int id);
	public int deleteAchievement(int id);
	public int deleteEducation(int year);
	public int deleteMessage(String email);
	public int deleteProject(HttpServletRequest request, String filename);
}

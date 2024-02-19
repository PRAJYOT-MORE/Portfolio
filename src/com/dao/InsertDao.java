package com.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public interface InsertDao {

	public int insertCourse(int id, String name, String description);
	public int insertAchievement(int id, int year, String title, String description);
	public int insertEducation(int year, String level, String description, String score);
	public int insertMessage(String name, String email, String description);
	public int insertProject(int id, String filename, HttpServletRequest request);
}

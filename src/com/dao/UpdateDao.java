package com.dao;

public interface UpdateDao {
	
	public int updateCourseName(String name, int id);
	public int updateCourseDescription(String description, int id);
	public int updateAchievementTitle(String title, int id);
	public int updateAchievementDescription(String description, int id);
	public int updateAchievementYear(int year, int id);
	public int updateEducationLevel(String level, int year);
	public int updateEducationDescription(String description, int year);
	public int updateEducationScore(String score, int year);
}
